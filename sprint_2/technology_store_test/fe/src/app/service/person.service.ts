import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Person} from '../model/person';
const API_URL = 'http://localhost:8080/api/customer';
@Injectable({
  providedIn: 'root'
})
export class PersonService {


  constructor(private http: HttpClient) {
  }

  getPersonInformation(): Observable<Person> {
    return this.http.get<Person>(
      API_URL + '/person-information');
  }
}
