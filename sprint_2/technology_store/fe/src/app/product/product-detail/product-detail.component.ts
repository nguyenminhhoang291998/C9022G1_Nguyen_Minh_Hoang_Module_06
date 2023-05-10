import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {ProductService} from '../../service/product.service';
import {Product} from '../../model/product';
import {Image} from '../../model/image';
import Swal from 'sweetalert2';
import {CartService} from '../../service/cart.service';
import {TokenStorageService} from '../../security-authentication/service/token-storage.service';
import {ShareDataService} from '../../service/share-data.service';
import {ShareService} from '../../security-authentication/service/share.service';
import {Cart} from '../../model/cart';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {
  detailProductId: number;
  productDetail: Product;
  imageList: Image[];
  imageMain: string;
  personId: number;
  cartList?: Cart[];
  quantityAllowed: number;
  quantityInput = 1;

  constructor(private activatedRoute: ActivatedRoute,
              private productService: ProductService,
              private cartService: CartService,
              private tokenStorageService: TokenStorageService,
              private shareDataService: ShareDataService,
              private shareService: ShareService) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(param => {
      this.detailProductId = +param.get('id');
      this.productService.getProductDetail(this.detailProductId).subscribe(data => {
        this.personId = this.tokenStorageService.getUser().personId;
        this.productDetail = data.product;
        this.imageList = data.imageList;
        this.imageMain = this.imageList[0].url;
        this.cartService.getCart().subscribe(cartList => {
          this.cartList = cartList;
          // tslint:disable-next-line:prefer-for-of
          for (let i = 0; i < this.cartList?.length; i++) {
            if (this.cartList[i].productId === this.detailProductId) {
              this.quantityAllowed = this.productDetail.productQuantity - this.cartList[i].orderedQuantity;
              break;
            } else {
              this.quantityAllowed = this.productDetail.productQuantity;
            }
          }
        });
      });
    });
  }

  change_image(event) {
    this.imageMain = event.target.getAttribute('src');
  }

  addProduct(idProduct: number) {
    this.cartService.addProduct(idProduct, this.quantityInput).subscribe(() => {
      Swal.fire({
        text: 'Sản phẩm đã được thêm vào giỏ hàng',
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
        this.shareService.sendClickEvent();
      });
    }, error => {
      Swal.fire({
        text: error.error,
        icon: 'error',
        showConfirmButton: false,
        timer: 1500
      });
    });
  }

  desc() {
    if (this.quantityInput <= 1) {
      Swal.fire({
        text: 'Số lượng phải lớn hơn 0',
        icon: 'error',
        showConfirmButton: false,
        timer: 1500
      });
    } else {
      this.quantityInput--;
    }
  }

  inc() {
    console.log(this.quantityAllowed);
    if (this.quantityInput === this.quantityAllowed) {
      Swal.fire({
        text: 'Rất tiếc, số lượng sản phẩm này trong kho chỉ còn ' + this.productDetail.productQuantity,
        icon: 'warning',
        showConfirmButton: false,
        timer: 3000
      });
    } else {
      this.quantityInput++;
    }
  }

  changQuantity(event) {
    const newQuantity = event.target.value;
    if (newQuantity.isNaN || newQuantity < 1) {
      Swal.fire({
        text: 'Số lượng không hợp lệ',
        icon: 'error',
        showConfirmButton: false,
        timer: 1500
      });
      this.quantityInput = 1;
    } else if (newQuantity > this.quantityAllowed) {
      Swal.fire({
        text: 'Rất tiếc, số lượng sản phẩm này trong kho chỉ còn ' + this.productDetail.productQuantity,
        icon: 'warning',
        showConfirmButton: false,
        timer: 3000
      });
      this.quantityInput = this.quantityAllowed;
      event.target.value = this.quantityInput;
    } else {
      this.quantityInput = newQuantity;
      event.target.value = this.quantityInput;
    }
  }
}
