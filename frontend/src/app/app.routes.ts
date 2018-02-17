import {StreamingModule} from './streaming/streaming.module';

export const routes = [
    { path: '', redirectTo: 'radyou', pathMatch: 'full' },
    { path: 'radyou', loadChildren: './streaming/streaming.module#StreamingModule' },
];
