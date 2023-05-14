import {Component, OnInit} from '@angular/core';
import {CartService} from '../../service/cart.service';
import {Cart} from '../../model/cart';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-history-detail',
  templateUrl: './history-detail.component.html',
  styleUrls: ['./history-detail.component.css']
})
export class HistoryDetailComponent implements OnInit {

  constructor(private cartService: CartService,
              private activatedRoute: ActivatedRoute) {
  }

  orderHistoryDetail?: Cart[];
  orderId?: number;

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(param => {
      this.orderId = +param.get('id');
      this.cartService.getOrderHistoryDetail(this.orderId).subscribe(data => {
        this.orderHistoryDetail = data;
      });
    });
  }
}
