import {Injectable} from '@angular/core';
import {TokenStorageService} from '../security-authentication/service/token-storage.service';
import {CartService} from './cart.service';
import {Router} from '@angular/router';
import {Cart} from '../model/cart';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ShareDataService {
  totalProduct = 0;
  personId: number;
  cartList: Cart[];

  constructor(private tokenStorageService: TokenStorageService,
              private cartService: CartService,
              private router: Router) {
  }

  getTotalProduct(): Observable<number> {
    return new Observable<number>((observer) => {
      if (this.tokenStorageService.getToken()) {
        this.personId = this.tokenStorageService.getUser().personId;
        this.cartService.getCart(this.personId).subscribe(data => {
          this.cartList = data;
          this.getQuantity();
          observer.next(this.totalProduct);
          observer.complete();
        });
      } else {
        this.router.navigateByUrl('/security/login');
        observer.next(0);
        observer.complete();
      }
    });
  }

  getQuantity() {
    this.totalProduct = 0;
    if (this.cartList) {
      // tslint:disable-next-line:prefer-for-of
      for (let i = 0; i < this.cartList.length; i++) {
        // tslint:disable-next-line:radix
        this.totalProduct += parseInt(String(this.cartList[i].orderedQuantity));
      }
    }
  }
}
