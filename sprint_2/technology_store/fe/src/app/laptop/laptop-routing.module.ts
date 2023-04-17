import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LaptopListComponent} from './laptop-list/laptop-list.component';
import {LaptopDetailComponent} from './laptop-detail/laptop-detail.component';


const routes: Routes = [
  {path: 'list', component: LaptopListComponent},
  {path: 'detail', component: LaptopDetailComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LaptopRoutingModule { }
