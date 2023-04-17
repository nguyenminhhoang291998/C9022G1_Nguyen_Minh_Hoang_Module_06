import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomePageComponent} from './common/home-page/home-page.component';


const routes: Routes = [
  {
    path: 'security',
    loadChildren: () => import('./security-authentication/security-authentication.module')
      .then(module => module.SecurityAuthenticationModule)
  }, {
    path: 'laptop',
    loadChildren: () => import('./laptop/laptop-routing.module')
      .then(module => module.LaptopRoutingModule)
  }, {
    path: 'cart',
    loadChildren: () => import('./cart/cart-routing.module')
      .then(module => module.CartRoutingModule)
  },
  {path: 'homepage', component: HomePageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
