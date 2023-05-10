import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomePageComponent} from './common/home-page/home-page.component';
import {PayComponent} from './common/pay/pay.component';
import {CustomerGuard} from './security-authentication/security-auth/customer.guard';
import {ErrorPageComponent} from './common/error-page/error-page.component';
import {EmployeeGuard} from './security-authentication/security-auth/employee.guard';
import {AdminGuard} from './security-authentication/security-auth/admin.guard';
import {AuthenticationGuard} from './security-authentication/security-auth/authentication.guard';
import {PersonalInformationComponent} from './personal-information/personal-information.component';


const routes: Routes = [
  {
    path: '', component: HomePageComponent
  }, {
    path: 'security',
    loadChildren: () => import('./security-authentication/security-authentication.module')
      .then(module => module.SecurityAuthenticationModule)
  }, {
    path: 'product',
    loadChildren: () => import('./product/product.module')
      .then(module => module.ProductModule), canActivate: [AuthenticationGuard]
  }, {
    path: 'cart',
    loadChildren: () => import('./cart/cart-routing.module')
      .then(module => module.CartRoutingModule), canActivate: [CustomerGuard]
  }, {
    path: 'history',
    loadChildren: () => import('./order-history/order-history.module')
      .then(module => module.OrderHistoryModule), canActivate: [CustomerGuard]
  }, {
    path: 'paypal', component: PayComponent, canActivate: [CustomerGuard]
  }, {
    path: 'personal-information', component: PersonalInformationComponent, canActivate: [AuthenticationGuard]
  }, {
    path: '**', component: ErrorPageComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
