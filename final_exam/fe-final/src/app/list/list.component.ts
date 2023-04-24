import {Component, OnInit} from '@angular/core';
import {Center} from '../model/center';
import {CenterService} from '../service/center.service';
import Swal from 'sweetalert2';
import {Employee} from '../model/employee';
import {EmployeeService} from '../service/employee.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  centerList: Center[];
  nameCenter: any;
  nameAdmin: any;
  centerDelete: Center;
  pageCount = 0;
  currentPage = 0;
  message: any;
  adminDetail: Employee;

  constructor(private centerService: CenterService,
              private employeeService: EmployeeService) {
  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.centerService.getAllEmployee(this.currentPage, this.nameCenter, this.nameAdmin).subscribe(dataList => {
      const data = dataList;
      this.centerList = data.content;
      console.log(this.centerList);
      this.pageCount = data.totalPages;
    });
  }

  search() {
    this.getAll();
  }

  clearInputs() {
  }

  previousPage() {
    if (this.currentPage > 0) {
      this.currentPage--;
    }
    this.getAll();
  }

  nextPage() {
    if (this.currentPage < this.pageCount - 1) {
      this.currentPage++;
    }
    this.getAll();
  }

  delete(id: number) {
    if (id != null) {
      return this.centerService.deleteById(this.centerDelete.id).subscribe(data => {
        Swal.fire(
          'Xóa cơ sở thành công',
          'success'
        );
        this.getAll();
      }, error => {
        Swal.fire(
          'Xóa cơ sở không thành công',
          'error'
        );
      });
    }
  }

  detail(idAdmin: number) {
    this.employeeService.findById(idAdmin).subscribe(data => {
      this.adminDetail = data;
    });
  }
}
