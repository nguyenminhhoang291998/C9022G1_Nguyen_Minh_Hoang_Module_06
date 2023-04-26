import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomePageComponent} from './common/home-page/home-page.component';
import {PayComponent} from './common/pay/pay.component';
import {CustomerGuard} from './security-authentication/security-auth/customer.guard';
import {ErrorPageComponent} from './common/error-page/error-page.component';


const routes: Routes = [
  {
    path: 'security',
    loadChildren: () => import('./security-authentication/security-authentication.module')
      .then(module => module.SecurityAuthenticationModule)
  }, {
    path: 'product',
    loadChildren: () => import('./product/product.module')
      .then(module => module.ProductModule), canActivate: [CustomerGuard]
  }, {
    path: 'cart',
    loadChildren: () => import('./cart/cart-routing.module')
      .then(module => module.CartRoutingModule), canActivate: [CustomerGuard]
  }, {
    path: '', component: HomePageComponent
  }, {
    path: 'paypal', component: PayComponent, canActivate: [CustomerGuard]},
  {
    path: '**', component: ErrorPageComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
