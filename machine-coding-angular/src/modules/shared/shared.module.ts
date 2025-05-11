import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import { HomePageComponent } from '../../pages/home-page/home-page.component';
import { RouterModule } from '@angular/router';
import { SolutionsModule } from '../solutions/solutions.module';



@NgModule({
  declarations: [
    NavbarComponent,
    HomePageComponent,
  ],
  imports: [
    CommonModule,
    RouterModule,
    SolutionsModule
  ],
  exports:[
    NavbarComponent,
    HomePageComponent
  ]
})
export class SharedModule { }
