import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { OrderHistoryRoutingModule } from './order-history-routing.module';
import { HistoryComponent } from './history/history.component';
import { HistoryDetailComponent } from './history-detail/history-detail.component';


@NgModule({
  declarations: [HistoryComponent, HistoryDetailComponent],
  imports: [
    CommonModule,
    OrderHistoryRoutingModule
  ]
})
export class OrderHistoryModule { }
