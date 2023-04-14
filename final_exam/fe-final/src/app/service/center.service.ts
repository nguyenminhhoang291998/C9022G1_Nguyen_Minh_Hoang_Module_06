import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Center} from '../model/center';
import {Observable} from 'rxjs';

const API_URL = 'http://localhost:8080';

@Injectable({
  providedIn: 'root'
})
export class CenterService {

  constructor(private http: HttpClient) {
  }

  getAllEmployee(page: number = 0, nameCenter: string = '', nameAdmin: string = ''): Observable<any> {
    return this.http.get<any>(
      API_URL + '/center/list?page=' + page + '&nameCenter=' +
      nameCenter + '&nameAdmin=' + nameAdmin);
  }

  deleteById(id: number) {
    return this.http.delete(API_URL + '/center/delete/' + id);
  }

  addCenter(center: Center, idAdmin: number) {
    return this.http.post(API_URL + '/center/create/' + idAdmin, {
      name: center.nameCenter,
      openingDate: center.openingDate,
      address: center.address,
    });
  }
}
