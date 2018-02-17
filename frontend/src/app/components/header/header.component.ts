import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  @Input() title: string;

  @Output() onLogout = new EventEmitter();
  @Output() oncreatePlaylist = new EventEmitter();
  @Output() onToggleSidenav = new EventEmitter();
  @Output() onToggleTheme = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  logout() {
    this.onLogout.emit();
  }

  createPlaylist() {
    this.oncreatePlaylist.emit();
  }

  toggleSidenav() {
    this.onToggleSidenav.emit();
  }

  toggleTheme() {
    this.onToggleTheme.emit();
  }
}
