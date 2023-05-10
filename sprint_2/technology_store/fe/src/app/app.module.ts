import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './common/header/header.component';
import { FooterComponent } from './common/footer/footer.component';
import { HomePageComponent } from './common/home-page/home-page.component';
import { ErrorPageComponent } from './common/error-page/error-page.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {CartModule} from './cart/cart.module';
import {AuthInterceptor} from './security-authentication/security-auth/auth.interceptor';
import {ProductModule} from './product/product.module';
import {DecimalPipe} from '@angular/common';
import { PayComponent } from './common/pay/pay.component';
import {OrderHistoryModule} from './order-history/order-history.module';
import { PersonalInformationComponent } from './personal-information/personal-information.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomePageComponent,
    ErrorPageComponent,
    PayComponent,
    PersonalInformationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    CartModule,
    OrderHistoryModule,
    ProductModule
  ],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}, DecimalPipe],
  exports: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
