import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ProductDetail} from '../model/product-detail';

const API_URL = 'http://localhost:8080/api/customer/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) {
  }

  getAllProduct(page: number, nameSearch: string, productTypeId: number, brandsId: number): Observable<any> {
    return this.http.get<any>(
      API_URL + '/list?page=' + page + '&productTypeId=' + productTypeId +
      '&brandsId=' + brandsId + '&nameSearch=' + nameSearch);
  }

  getProductDetail(id: number): Observable<ProductDetail> {
    return this.http.get<ProductDetail>(
      API_URL + '/detail?productId=' + id );
  }
}
