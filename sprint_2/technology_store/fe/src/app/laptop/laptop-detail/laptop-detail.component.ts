import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-laptop-detail',
  templateUrl: './laptop-detail.component.html',
  styleUrls: ['./laptop-detail.component.css']
})
export class LaptopDetailComponent implements OnInit {
  img = '../../../assets/img/home/mac.png' ;

  constructor() { }

  ngOnInit(): void {
  }

  change_image(event) {
    this.img = event.target.getAttribute('src');
  }
}
