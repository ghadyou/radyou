import {RouterModule, Routes} from '@angular/router';

export const routes: Routes = [
  { path: '', redirectTo: '/radyou', pathMatch: 'full'},
  {
    path: 'radyou',
    loadChildren: './streaming/streaming.module#StreamingModule',
  }
];

export const appRoutingProviders: any[] = [

];

export const routing = RouterModule.forRoot(routes, {enableTracing: false, useHash: true});
