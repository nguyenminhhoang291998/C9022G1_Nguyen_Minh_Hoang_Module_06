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

  getCart(id: number): Observable<any> {
    return this.http.get<any>(
      API_URL + '/cart?id=' + id);
  }

  changeQuantity(orderDetailId: number, quantity: number) {
    return this.http.get<any>(
      API_URL + '/changeQuantity?orderDetailId=' + orderDetailId + '&quantity=' + quantity);
  }

  addProduct(personId: number, idProduct: number) {
    return this.http.get<any>(
      API_URL + '/addProduct?personId=' + personId + '&productId=' + idProduct);
  }

  deleteOrderDetail(orderDetailId: number) {
    return this.http.delete<any>(
      API_URL + '/deleteOrderDetail?orderDetailId=' + orderDetailId);
  }
}
