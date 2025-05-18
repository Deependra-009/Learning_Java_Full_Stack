import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from '../../components/navbar/navbar.component';
import { HomePageComponent } from '../../pages/home-page/home-page.component';



@NgModule({
  declarations: [
    NavbarComponent,
    HomePageComponent
  ],
  imports: [
    CommonModule
  ],
  exports:[
    NavbarComponent,
    HomePageComponent
  ]
})
export class SharedModule { }
