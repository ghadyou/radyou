import {Component, OnInit, ViewChild} from '@angular/core';
import {WebSocketSubject} from 'rxjs/observable/dom/WebSocketSubject';
import {WebsocketService} from '../services/websocket-service';

@Component({
  selector: 'radyou-streaming',
  template: `
    <div class="video">
      <video controls (click)="toggleVideo($event)" #videoPlayer>
        <source src="{{videoSource}}" type="video/mp4" />
        Browser not supported
      </video>
    </div>`,
  styles: [`
  `]
})
export class StreamingComponent  implements OnInit{
  videoSource;
  audio;
  @ViewChild('videoPlayer') videoplayer: any;
  constructor(private wsService: WebsocketService) {
  }


  toggleVideo(event: any) {
    this.videoplayer.nativeElement.play();
  }

  ngOnInit(): void {
    this.wsService.connect('ws://localhost:8080/signaling');
  }


}
