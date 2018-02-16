import { Component } from '@angular/core';

@Component({
  selector: 'radyou-app',
  template: `
    <radyou-app-header></radyou-app-header>
    <router-outlet></router-outlet>
    <radyou-app-footer></radyou-app-footer>
  `,
})
export class AppComponent {
}
