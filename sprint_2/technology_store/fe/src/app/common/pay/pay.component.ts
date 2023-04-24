import { Component, OnInit } from '@angular/core';
import {render} from 'creditcardpayments/creditCardPayments';

@Component({
  selector: 'app-pay',
  templateUrl: './pay.component.html',
  styleUrls: ['./pay.component.css']
})
export class PayComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    render({
      id: '#myPaypalButtons',
      currency: 'USD',
      value: '100.00',
      onApprove: (details => {
        alert('thành công!');
      })
    })
  }

}
