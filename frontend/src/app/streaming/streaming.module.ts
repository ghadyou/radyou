import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import {StreamingComponent} from './containers/streaming';
import {WebsocketService} from './services/websocket-service';

@NgModule({
  imports: [
    RouterModule.forChild([
      { path: '', component: StreamingComponent }
    ])
  ],
  declarations: [
    StreamingComponent
  ],
  providers: [
    WebsocketService
  ]
})
export class StreamingModule {}
