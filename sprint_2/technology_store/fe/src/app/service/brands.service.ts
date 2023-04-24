import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

const API_URL = 'http://localhost:8080/api/customer/brands';

@Injectable({
  providedIn: 'root'
})
export class BrandsService {

  constructor(private http: HttpClient) {
  }

  getAllBrands(): Observable<any> {
    return this.http.get<any>(
      API_URL + '/list');
  }
}
