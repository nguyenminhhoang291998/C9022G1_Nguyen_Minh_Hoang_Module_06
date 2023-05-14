import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ProductType} from '../model/product-type';

const API_URL = 'http://localhost:8080/api/customer/productType';

@Injectable({
  providedIn: 'root'
})
export class ProductTypeService {

  constructor(private http: HttpClient) {
  }

  getAllProductType(): Observable<ProductType[]> {
    return this.http.get<ProductType[]>(
      API_URL + '/list');
  }
}
