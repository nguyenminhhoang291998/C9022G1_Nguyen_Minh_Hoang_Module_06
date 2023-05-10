import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HistoryComponent} from './history/history.component';
import {HistoryDetailComponent} from './history-detail/history-detail.component';


const routes: Routes = [
  {path: 'list', component: HistoryComponent},
  {path: 'detail/:id', component: HistoryDetailComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class OrderHistoryRoutingModule { }
