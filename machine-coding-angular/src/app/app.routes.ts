import { Routes } from '@angular/router';
import { HomePageComponent } from '../pages/home-page/home-page.component';
import { QuestionsData } from '../constants/application.constans';
import { Solution1Component } from '../pages/solutions/solution-1/solution-1.component';
import { Solution2Component } from '../pages/solutions/solution-2/solution-2.component';

export const routes: Routes = [
    { path: '', component: HomePageComponent },
    {
      path:QuestionsData[0].link,
      component:Solution1Component
    },
    {
      path:QuestionsData[1].link,
      component:Solution2Component
    }
  ];
