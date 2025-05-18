import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import { HomePageComponent } from '../../pages/home-page/home-page.component';
import { TopicsModule } from '../topic-module/topics/topics.module';



@NgModule({
  declarations: [
    NavbarComponent,
    HomePageComponent,
  ],
  imports: [
    CommonModule,
    TopicsModule,
],
  exports:[
    NavbarComponent,
    HomePageComponent,
  ]
})
export class SharedModule { }
