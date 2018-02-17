import {Component, OnInit, ViewChild} from '@angular/core';
import {WebSocketSubject} from 'rxjs/observable/dom/WebSocketSubject';
import {WebsocketService} from '../services/websocket-service';

@Component({
  selector: 'radyou-streaming',
  template: `
    <div class="video">
      <video controls (click)="toggleVideo()" #videoPlayer>
        <source src="{{videoSource}}" type="video/mp4" />
        Browser not supported
      </video>
    </div>`,
  styles: [`
  `]
})
export class StreamingComponent  implements OnInit{
  audio: Audio;
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
