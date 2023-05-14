import { Component, OnInit } from '@angular/core';
import {CartService} from '../../service/cart.service';
import {Cart} from '../../model/cart';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

  orderHistoryList?: Cart[];
  constructor(private cartService: CartService) { }

  ngOnInit(): void {
    this.cartService.getOrderHistory().subscribe(data => {
      this.orderHistoryList = data;
    });
  }
}
