import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {ProductService} from '../../service/product.service';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {
  detailProductId: number;

  constructor(private activatedRoute: ActivatedRoute,
              private productService: ProductService) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(param => {
      this.detailProductId = +param.get('id');
      this.productService.getProductDetail(this.detailProductId);
    });
  }

  change_image(event) {
    // this.img = event.target.getAttribute('src');
  }

}
