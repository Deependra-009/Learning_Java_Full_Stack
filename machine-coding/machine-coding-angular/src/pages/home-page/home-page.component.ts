import { Component } from '@angular/core';
import { QuestionsData } from '../../constants/application.constans';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrl: './home-page.component.css'
})
export class HomePageComponent {

  constructor(
    private router:Router
  ){}

  QuestionsData=QuestionsData;


  navigateToSolution(data:any){
    this.router.navigateByUrl(data.link);
  }

}
