import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';

import {StoreModule} from '@ngrx/store';
import {StoreRouterConnectingModule} from '@ngrx/router-store';

import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import 'hammerjs';

import {SharedModule} from './shared/shared.module';

import {HeaderComponent} from './components/header/header.component';
import {SidebarComponent} from './components/sidebar/sidebar.component';

import {routes} from './app.routes';
import {initialState, reducers} from './store';
import {StreamingModule} from './streaming/streaming.module';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SidebarComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    SharedModule.forRoot(),
    RouterModule.forRoot(routes),
    StoreRouterConnectingModule,
    StoreModule.forRoot(reducers, <any>initialState),
    StreamingModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
