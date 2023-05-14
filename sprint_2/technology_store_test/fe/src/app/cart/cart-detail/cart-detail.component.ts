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
    this.getPersonInfo();
  }

   getPersonInfo() {
    this.cartService.getCart().subscribe(async data => {
      this.cartList = data;
      // tslint:disable-next-line:prefer-for-of
      for (let i = 0; i < this.cartList?.length; i++) {
        if (this.cartList[i].orderedQuantity > this.cartList[i].productQuantity) {
          await Swal.fire({
            text: 'Rất tiếc, sản phẩm ' + this.cartList[i].productName + ' hiện tại số lượng chỉ còn ' + this.cartList[i].productQuantity,
            icon: 'error',
            confirmButtonText: 'ok',
            allowOutsideClick: false,
            allowEscapeKey: false
          });
          this.getCart(this.cartList[i].orderDetailId, this.cartList[i].productQuantity);
        }
      }
      this.getQuantityAndTotalPrice();
    });
  }

  changQuantity(event, cart: Cart) {
    const newQuantity = event.target.value;
    if (newQuantity.isNaN || newQuantity < 1) {
      Swal.fire({
        text: 'Số lượng không hợp lệ',
        icon: 'error',
        showConfirmButton: false,
        timer: 1500
      });
      this.getCart(cart.orderDetailId, cart.orderedQuantity);
    } else if (newQuantity >= cart.productQuantity) {
      Swal.fire({
        text: 'Rất tiếc, sản phẩm ' + cart.productName + ' hiện tại số lượng chỉ còn ' + cart.productQuantity,
        icon: 'warning',
        showConfirmButton: false,
        timer: 3000
      });
      this.getCart(cart.orderDetailId, cart.productQuantity);
    } else {
      this.getCart(cart.orderDetailId, newQuantity);
    }
  }

  inc(cart: Cart) {
    if (cart.orderedQuantity === cart.productQuantity) {
      Swal.fire({
        text: 'Rất tiếc, sản phẩm ' + cart.productName + ' hiện tại số lượng chỉ còn ' + cart.productQuantity,
        icon: 'warning',
        showConfirmButton: false,
        timer: 3000
      });
      this.getCart(cart.orderDetailId, cart.productQuantity);
    } else {
      cart.orderedQuantity++;
      this.getCart(cart.orderDetailId, cart.orderedQuantity);
    }
  }

  desc(cart: Cart) {
    if (cart.orderedQuantity <= 1) {
      Swal.fire({
        text: 'Số lượng phải lớn hơn 0',
        icon: 'error',
        showConfirmButton: false,
        timer: 1500
      });
    } else {
      cart.orderedQuantity--;
      this.getCart(cart.orderDetailId, cart.orderedQuantity);
    }
  }

  getCart(orderDetailId: number, quantity: number) {
    this.cartService.changeQuantity(orderDetailId, quantity).subscribe(() => {
      this.cartService.getCart().subscribe(data => {
        this.cartList = data;
        this.getQuantityAndTotalPrice();
      });
    });
  }

  getQuantityAndTotalPrice() {
    this.totalProduct = 0;
    this.totalPrice = 0;
    if (this.cartList) {
      this.totalPrice = this.cartList[0].totalPrice;
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
      this.getPersonInfo();
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
