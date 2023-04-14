import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Employee} from '../model/employee';
import {Observable} from 'rxjs';
const API_URL = 'http://localhost:8080';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient) {
  }

  findById(id: number): Observable<Employee> {
    return this.http.get<Employee>('http://localhost:8080/employee/' + id);
  }
  getEmployeeAddNewCenter(): Observable<Employee[]> {
    return this.http.get<Employee[]>('http://localhost:8080/employee-add-center');
  }
}
