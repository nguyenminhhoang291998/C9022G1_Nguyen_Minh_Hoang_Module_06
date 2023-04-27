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
        console.log(data);
        console.log(this.productDetail);
        console.log(this.imageList);
      });
    });
  }

  change_image(event) {
    this.imageMain = event.target.getAttribute('src');
  }

  addProduct(idProduct: number) {
    this.cartService.addProduct(this.personId, idProduct).subscribe(() => {
      Swal.fire({
        text: 'Sản phẩm đã được thêm vào giỏ hàng.',
        icon: 'success',
        showConfirmButton: false,
        timer: 1500
      });
      this.shareDataService.getTotalProduct().subscribe(totalProduct => {
        this.shareService.sendClickEvent();
      });
    });
  }
}
