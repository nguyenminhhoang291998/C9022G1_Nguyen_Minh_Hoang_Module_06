import {Component, OnInit} from '@angular/core';
import {ProductType} from '../../model/product-type';
import {Brands} from '../../model/brands';
import {ProductService} from '../../service/product.service';
import {ProductTypeService} from '../../service/product-type.service';
import {BrandsService} from '../../service/brands.service';
import {TokenStorageService} from '../../security-authentication/service/token-storage.service';
import {Router} from '@angular/router';
import {CartService} from '../../service/cart.service';
import {ProductList} from '../../model/product-list';
import Swal from 'sweetalert2';
import {ShareDataService} from '../../service/share-data.service';
import {ShareService} from '../../security-authentication/service/share.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  totalPages = 0;
  currentPage = 0;
  productList: ProductList[];
  productTypeList: ProductType[];
  brandsList: Brands[];
  nameProduct = '';
  productType = 0;
  brands = 0;
  personId: number;
  isSort = false;

  constructor(private productService: ProductService,
              private productTypeService: ProductTypeService,
              private brandsService: BrandsService,
              private tokenStorageService: TokenStorageService,
              private router: Router,
              private cartService: CartService,
              private shareDataService: ShareDataService,
              private shareService: ShareService) {
  }

  ngOnInit(): void {
    this.getPersonId();
    this.getAllProduct();
  }

  getAllProduct() {
    this.productTypeService.getAllProductType().subscribe(productTypeList => {
      this.productTypeList = productTypeList;
      this.brandsService.getAllBrands().subscribe(brandsList => {
        this.brandsList = brandsList;
        this.productService.getAllProduct(this.currentPage, this.nameProduct, this.productType, this.brands, this.isSort)
          .subscribe(data => {
            this.productList = data.content;
            this.totalPages = data.totalPages;
          });
      });
    });
  }

  getPersonId() {
    if (this.tokenStorageService.getToken()) {
      this.personId = this.tokenStorageService.getUser().personId;
    } else {
      this.router.navigateByUrl('/security/login');
    }
  }

  previousPage() {
    if (this.currentPage > 0) {
      this.currentPage--;
    }
    this.getAllProduct();
  }

  nextPage() {
    if (this.currentPage < this.totalPages - 1) {
      this.currentPage++;
    }
    this.getAllProduct();
  }

  search() {
    this.currentPage = 0;
    this.isSort = false;
    this.getAllProduct();
  }

  addProduct(idProduct: number) {
    this.cartService.addProduct(this.personId, idProduct).subscribe(() => {
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
    });
  }

  sort() {
    this.isSort = true;
    this.getAllProduct();
  }
}
