import {Component, OnInit, ViewChild} from '@angular/core';
import {TokenStorageService} from '../../security-authentication/service/token-storage.service';
import {Router} from '@angular/router';
import {CartService} from '../../service/cart.service';
import {Cart} from '../../model/cart';
import Swal from 'sweetalert2';
import {ShareDataService} from '../../service/share-data.service';
import {ShareService} from '../../security-authentication/service/share.service';


@Component({
  selector: 'app-cart-detail',
  templateUrl: './cart-detail.component.html',
  styleUrls: ['./cart-detail.component.css']
})
export class CartDetailComponent implements OnInit {
  personId: number;
  cartList?: Cart[];
  totalPrice: number;
  totalProduct: number;
  productDelete: Cart;

  constructor(private tokenStorageService: TokenStorageService,
              private router: Router,
              private cartService: CartService,
              private shareDataService: ShareDataService,
              private shareService: ShareService) {
  }

  ngOnInit(): void {
    this.getPersonId();
  }

  getPersonId() {
    if (this.tokenStorageService.getToken()) {
      this.personId = this.tokenStorageService.getUser().personId;
      this.cartService.getCart(this.personId).subscribe(data => {
        this.cartList = data;
        this.getQuantityAndTotalPrice();
      });
    } else {
      this.router.navigateByUrl('/security/login');
    }
  }

  changQuantity(event, cart: Cart) {
    cart.orderedQuantity = event.target.value;
    this.getCart(cart.orderDetailId, cart.orderedQuantity);
  }

  inc(cart: Cart) {
    cart.orderedQuantity++;
    this.getCart(cart.orderDetailId, cart.orderedQuantity);
  }

  desc(cart: Cart) {
    if (cart.orderedQuantity > 1) {
      cart.orderedQuantity--;
      this.getCart(cart.orderDetailId, cart.orderedQuantity);
    }
  }

  getCart(orderDetailId: number, quantity: number) {
    this.cartService.changeQuantity(orderDetailId, quantity).subscribe(() => {
      this.cartService.getCart(this.personId).subscribe(data => {
        this.cartList = data;
        this.getQuantityAndTotalPrice();
      });
    });
  }

  getQuantityAndTotalPrice() {
    this.totalProduct = 0;
    this.totalPrice = 0;
    if (this.cartList) {
      // tslint:disable-next-line:prefer-for-of
      for (let i = 0; i < this.cartList?.length; i++) {
        // @ts-ignore
        // tslint:disable-next-line:radix
        this.totalProduct += parseInt(this.cartList[i].orderedQuantity);
        this.totalPrice += (this.cartList[i].productPrice * this.cartList[i].orderedQuantity);
      }
      this.shareDataService.getTotalProduct().subscribe(totalProduct => {
        this.totalProduct = totalProduct;
        this.shareService.sendClickEvent();
      });
    }
  }

  showModalDeleteProduct(cart: Cart) {
    this.productDelete = cart;
    const modal = document.getElementById('deleteModal');
    modal.classList.add('show');
  }

  delete(orderDetailId: number) {
    this.cartService.deleteOrderDetail(orderDetailId).subscribe(() => {
      Swal.fire({
        text: 'Xóa sản phẩm thành công',
        icon: 'success',
        toast: true,
        position: 'top-end',
        showConfirmButton: false,
        timer: 2000,
        customClass: {
          popup: 'my-toast',
          icon: 'my-icon'
        }
      });
      this.shareDataService.getTotalProduct().subscribe(totalProduct => {
        this.totalProduct = totalProduct;
        this.shareService.sendClickEvent();
      });
      this.getPersonId();
    }, error => {
      Swal.fire({
        text: 'Đã có lỗi xảy ra. Xóa sản phẩm thất bại!',
        icon: 'error',
        showConfirmButton: false,
        timer: 1500
      });
    });
  }

}
