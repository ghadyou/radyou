import { isPlatformBrowser } from '@angular/common';
import { Store } from '@ngrx/store';
import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { MatSliderChange } from '@angular/material';

@Component({
  selector: 'app-player-controller',
  templateUrl: './player-controller.component.html',
  styleUrls: ['./player-controller.component.scss']
})
export class PlayerControllerComponent implements OnInit {
  playing = true;
  volume = 0.5;
  collapsed = true;

  @Output() onTogglePlayer = new EventEmitter();

  constructor() { }

  ngOnInit() {
    this.updateSidenavForWindow();
  }

  /**
   * Update the sidenav property for the current window.
   */
  updateSidenavForWindow() {
    if (isPlatformBrowser) {
      if (window.innerWidth < 768) {
      } else {
        this.collapsed = false;
      }
    }
  }

  /**
   * Pause the player.
   */
  playerPause() {
    this.playing = false;
  }

  /**
   * Resume playing.
   */
  playerResume() {
    this.playing = true;
  }

  /**
   * Move to previous song (if exists).
   */
  playerPrev() {
  }

  /**
   * Move to next song (if exists).
   */
  playerNext() {
  }

  /**
   * Change volume.
   */
  updateVolume(sliderChange: MatSliderChange) {
    this.volume = sliderChange.value;
  }

  /**
   * Expand player controls on mobile.
   */
  toggleExpandPlayer() {
    this.collapsed = this.collapsed ? false : true;
    this.onTogglePlayer.emit(this.collapsed);
  }
}
