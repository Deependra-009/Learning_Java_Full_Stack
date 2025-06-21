import { Routes } from '@angular/router';
import { HomePageComponent } from '../pages/home-page/home-page.component';
import { TopicsData } from '../constants/application.constans';
import { Topic1Component } from '../pages/topics/topic-1/topic-1.component';
import { Topic2Component } from '../pages/topics/topic-2/topic-2.component';

export const routes: Routes = [
    { path: '', component: HomePageComponent },
    {
        path:TopicsData[0].link,
        component:Topic1Component
    },
    {
        path:TopicsData[1].link,
        component:Topic2Component
    }
];
