import {Component, OnInit} from '@angular/core';
import {render} from 'creditcardpayments/creditCardPayments';
import {ShareDataService} from '../../service/share-data.service';
import {Observable} from 'rxjs';
import Swal from 'sweetalert2';
import {Router} from '@angular/router';
import {CartService} from '../../service/cart.service';
import {ShareService} from '../../security-authentication/service/share.service';
import {Cart} from '../../model/cart';

@Component({
  selector: 'app-pay',
  templateUrl: './pay.component.html',
  styleUrls: ['./pay.component.css']
})
export class PayComponent implements OnInit {
  totalPrice = 0;
  cartList?: Cart[];

  constructor(private shareDataService: ShareDataService,
              private shareService: ShareService,
              private router: Router,
              private cartService: CartService) {
  }

  ngOnInit(): void {
    this.cartService.getCart().subscribe(data => {
      this.cartList = data;
      // tslint:disable-next-line:prefer-for-of
      for (let i = 0; i < this.cartList?.length; i++) {
        if (this.cartList[i].orderedQuantity > this.cartList[i].productQuantity) {
           Swal.fire({
            text: 'Số lượng đã bị thay đổi, mời bạn chọn lại sản phẩm.',
            icon: 'error',
            showConfirmButton: false,
            timer: 1500
          });
           this.router.navigateByUrl('/cart');
        }
      }
      this.shareDataService.getTotalPrice().subscribe(totalProduct => {
        this.totalPrice = +(totalProduct / 23000).toFixed(2);
        render({
          id: '#myPaypalButtons',
          currency: 'USD',
          value: this.totalPrice.toString(),
          onApprove: (async details => {
            this.cartService.paymentOrder().subscribe(async () => {
              await Swal.fire({
                text: 'Thanh toán thành công.',
                icon: 'success',
                showConfirmButton: false,
                timer: 1500
              });
              await this.shareService.sendClickEvent();
              await this.router.navigateByUrl('/product/list');
            }, async error => {
              await Swal.fire({
                text: error.error,
                icon: 'error',
                showConfirmButton: false,
                timer: 1500
              });
              await this.router.navigateByUrl('/cart');
            });
          })
        });
      });
    });
  }
}
