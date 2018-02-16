import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { AppComponent } from './app.component';
import {appRoutingProviders, routes, routing} from './routes';
import {RouterModule} from '@angular/router';


@NgModule({
  imports: [
    BrowserModule,
    routing,
    MDBBootstrapModule.forRoot(),

  ],
  declarations: [
  AppComponent
],
  providers: [appRoutingProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
