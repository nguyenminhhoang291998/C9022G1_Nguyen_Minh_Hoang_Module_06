import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {CenterService} from '../service/center.service';
import {Router} from '@angular/router';
import Swal from 'sweetalert2';
import {Employee} from '../model/employee';
import {EmployeeService} from '../service/employee.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  formCenter: FormGroup;
  employeeList: Employee[];
  idAdmin: number;
  nameCenterError: '';

  constructor(private centerService: CenterService,
              private employeeService: EmployeeService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.employeeService.getEmployeeAddNewCenter().subscribe(data => {
      this.formCenter = new FormGroup({
        nameCenter: new FormControl(),
        openingDate: new FormControl(),
        address: new FormControl(),
        admin: new FormControl(),
      });
      this.employeeList = data;
      console.log(this.employeeList);
    });
  }

  submitAdd() {
    this.centerService.addCenter(this.formCenter.value, this.formCenter.get('admin').value).subscribe(next => {
      this.router.navigateByUrl('/');
      Swal.fire({
        icon: 'success',
        iconColor: 'darkorange',
        title: 'Thêm cơ sở thành công.',
        confirmButtonText: 'Xác nhận',
        confirmButtonColor: 'darkorange'
      });
    }, error => {
      console.log(error);
      Swal.fire({
        position: 'center',
        icon: 'error',
        title: 'Thêm mới thất bại!',
        showConfirmButton: false,
        timer: 2000
      });
      // tslint:disable-next-line:prefer-for-of
      for (let i = 0; i < error.error.length; i++) {
        if (error.error[i].field === 'name') {
          this.nameCenterError = error.error[i].defaultMessage;
        } else {
          // this.formError = error.error[i].defaultMessage;
        }
      }
    });
  }

  choiceAdmin(id: number) {
    alert(id);
  }
}
