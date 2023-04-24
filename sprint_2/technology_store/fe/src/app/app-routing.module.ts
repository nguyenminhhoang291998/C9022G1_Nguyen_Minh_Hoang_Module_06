import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomePageComponent} from './common/home-page/home-page.component';
import {PayComponent} from './common/pay/pay.component';


const routes: Routes = [
  {
    path: 'security',
    loadChildren: () => import('./security-authentication/security-authentication.module')
      .then(module => module.SecurityAuthenticationModule)
  }, {
    path: 'product',
    loadChildren: () => import('./product/product.module')
      .then(module => module.ProductModule)
  }, {
    path: 'cart',
    loadChildren: () => import('./cart/cart-routing.module')
      .then(module => module.CartRoutingModule)
  },
  {path: 'homepage', component: HomePageComponent},
  {path: 'paypal', component: PayComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
