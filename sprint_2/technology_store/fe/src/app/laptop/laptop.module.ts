import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LaptopRoutingModule } from './laptop-routing.module';
import { LaptopListComponent } from './laptop-list/laptop-list.component';
import { LaptopDetailComponent } from './laptop-detail/laptop-detail.component';


@NgModule({
  declarations: [LaptopListComponent, LaptopDetailComponent],
  imports: [
    CommonModule,
    LaptopRoutingModule
  ]
})
export class LaptopModule { }
