import {Component, OnInit} from '@angular/core';
import {Product} from '../../model/product';
import {ProductType} from '../../model/product-type';
import {Brands} from '../../model/brands';
import {ProductService} from '../../service/product.service';
import {ProductTypeService} from '../../service/product-type.service';
import {BrandsService} from '../../service/brands.service';
import {TokenStorageService} from '../../security-authentication/service/token-storage.service';
import {Router} from '@angular/router';
import {CartService} from '../../service/cart.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  totalPages = 0;
  currentPage = 0;
  productList: Product[];
  productTypeList: ProductType[];
  brandsList: Brands[];
  nameProduct = '';
  productType = 0;
  brands = 0;
  personId: number;

  constructor(private productService: ProductService,
              private productTypeService: ProductTypeService,
              private brandsService: BrandsService,
              private tokenStorageService: TokenStorageService,
              private router: Router,
              private cartService: CartService) {
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
        this.productService.getAllProduct(this.currentPage, this.nameProduct, this.productType, this.brands).subscribe(data => {
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
    this.getAllProduct();
  }

  addProduct(idProduct: number) {
    this.cartService.addProduct(this.personId, idProduct);
  }
}
