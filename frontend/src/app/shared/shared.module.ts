import {ModuleWithProviders, NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgxChartsModule} from '@swimlane/ngx-charts';

import {
  MatButtonModule,
  MatCardModule,
  MatCheckboxModule,
  MatChipsModule,
  MatDialogModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatMenuModule,
  MatRadioModule,
  MatSidenavModule,
  MatSliderModule,
  MatSlideToggleModule,
  MatTabsModule,
  MatToolbarModule,
  MatTooltipModule,
} from '@angular/material';

import {InfiniteScrollModule} from 'ngx-infinite-scroll';
import {MapToIterable} from './pipes/mapToIterable';

import {CardComponent} from './components/card/card.component';
import {PlayerControllerComponent} from './../components/player-controller/player-controller/player-controller.component';
import {ViewerBoxComponent} from './components/viewer-box/viewer-box.component';
import {WeatherBoxComponent} from './components/weather-box/weather-box.component';
import {IconsButtonsComponent} from './components/icons-buttons/icons-buttons.component';
import {UserBoxComponent} from './components/user-box/user-box.component';
import {IconBoxComponent} from './components/icon-box/icon-box.component';
import {HttpClientModule} from '@angular/common/http';

const SHARED_MODULES = [
  CommonModule,
  MatSidenavModule,
  MatToolbarModule,
  MatIconModule,
  MatButtonModule,
  InfiniteScrollModule,
  RouterModule,
  MatChipsModule,
  MatCardModule,
  MatSliderModule,
  MatDialogModule,
  MatTooltipModule,
  MatRadioModule,
  MatListModule,
  MatMenuModule,
  MatTabsModule,
  MatCheckboxModule,
  MatInputModule,
  FormsModule,
  ReactiveFormsModule,
  MatSlideToggleModule,
  NgxChartsModule,
  HttpClientModule,
];

const SHARED_COMPONENTS = [
  CardComponent,
  IconBoxComponent,
  PlayerControllerComponent,
  ViewerBoxComponent,
  WeatherBoxComponent,
  IconsButtonsComponent,
  UserBoxComponent,
];

const SHARED_PIPES = [
  MapToIterable,
];

@NgModule({
  imports: [
    ...SHARED_MODULES,
  ],
  declarations: [
    ...SHARED_COMPONENTS,
    ...SHARED_PIPES,
  ],
  exports: [
    ...SHARED_MODULES,
    ...SHARED_COMPONENTS,
    ...SHARED_PIPES,
  ]
})
export class SharedModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: SharedModule,
    };
  }
}
