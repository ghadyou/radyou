import {NavigationEnd, Router} from '@angular/router';
import {Component, HostListener, OnInit, ViewChild} from '@angular/core';
import {isPlatformBrowser} from '@angular/common';
import {MatDialog, MatSidenav} from '@angular/material';
import {OverlayContainer} from '@angular/cdk/overlay';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'Radyou';
  @ViewChild('sidenav') sidenav: MatSidenav;
  navMode = 'side';

  playerCollapsed = true;

  darkTheme = false;

  singlePage = false;

  singlePages = [
    '/user/login'
  ];

  constructor(
    public dialog: MatDialog,
    private overlayContainer: OverlayContainer,
    private router: Router
  ) {

  }

  isMobile() {
    return isPlatformBrowser && (window.innerWidth < 768);
  }

  ngOnInit() {
    this.updateSidenavForWindow();
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        if (!this.isMobile()) {
          this.singlePages.includes(event.url) ? this.singlePage = true : this.singlePage = false;
          this.singlePage ? this.sidenav.close() : this.sidenav.open();
        }
      }
    });
    if (this.darkTheme) {
      this.overlayContainer.getContainerElement().classList.add('zondimo-dark-theme');
    }
  }

  /**
   * Update the sidenav property for the current window.
   */
  updateSidenavForWindow() {
    if (this.isMobile()) {
      this.navMode = 'over';
      this.sidenav.close();
    } else {
      this.sidenav.open();
      this.playerCollapsed = false;
    }
  }

  /**
   * Listen to window resize.
   */
  @HostListener('window:resize', ['$event'])
  onResize(event) {
    if (this.isMobile()) {
      this.navMode = 'over';
    } else {
      this.navMode = 'side';
      this.playerCollapsed = false;
    }
  }

  logout() {
    // TODO.
  }

  toggleSidenav() {
    this.sidenav.toggle();
  }

  /**
   * Player collapsed event callback
   *
   * @param collapsed
   *  Info on if the player is collapsed.
   */
  playerCollapseToggle(collapsed) {
    this.playerCollapsed = collapsed;
  }

  /**
   * Toggle the theme from dark to light.
   */
  toggleTheme() {
    this.darkTheme = this.darkTheme ? false : true;
  }
}
