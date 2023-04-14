import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  startDate: any;
  endDate: any;
  nameSearch: any;
  message: any;
  employees: any;
  employeeDelete: any;
  pageCount = 0;
  currentPage = 0;

  constructor() { }

  ngOnInit(): void {
  }

  search() {
  }

  clearInputs() {
  }

  previousPage() {
  }

  goToPage(pageNumber: any) {
  }

  nextPage() {
  }

  delete(id: any) {
  }
}
