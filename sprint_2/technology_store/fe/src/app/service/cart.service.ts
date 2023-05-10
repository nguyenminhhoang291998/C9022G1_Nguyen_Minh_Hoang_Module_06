import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

const API_URL = 'http://localhost:8080/api/customer';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private http: HttpClient) {
  }

  getCart(): Observable<any> {
    return this.http.get<any>(
      API_URL + '/cart');
  }

  getOrderHistory(): Observable<any> {
    return this.http.get<any>(
      API_URL + '/order-history-list');
  }

  getOrderHistoryDetail(orderId: number): Observable<any> {
    return this.http.get<any>(
      API_URL + '/order-history-detail?orderId=' + orderId);
  }

  changeQuantity(orderDetailId: number, quantity: number) {
    return this.http.get<any>(
      API_URL + '/changeQuantity?orderDetailId=' + orderDetailId + '&quantity=' + quantity);
  }

  addProduct(idProduct: number, quantity: number) {
    return this.http.get<any>(
      API_URL + '/addProduct?productId=' + idProduct + '&quantity=' + quantity);
  }

  deleteOrderDetail(orderDetailId: number) {
    return this.http.delete<any>(
      API_URL + '/deleteOrderDetail?orderDetailId=' + orderDetailId);
  }


  paymentOrder() {
    return this.http.get<any>(
      API_URL + '/payment');
  }
}
