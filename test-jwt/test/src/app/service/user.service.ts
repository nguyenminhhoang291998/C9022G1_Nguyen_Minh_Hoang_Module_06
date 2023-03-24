import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from '../model/user';
const URL_API = 'http://localhost:8080/api/';
@Injectable({
  providedIn: 'root'
})
export class UserService {
  httpOptions: any;
  isLoggedIn: boolean;

  constructor(private http: HttpClient) {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      }),
      'Access-Control-Allow-Origin': 'http://localhost:4200',
      'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS'
    };
  }

  login(user): Observable<any> {
    return this.http.post(URL_API + 'login', {
      username: user.username,
      password: user.package
    }, this.httpOptions);
  }
}
