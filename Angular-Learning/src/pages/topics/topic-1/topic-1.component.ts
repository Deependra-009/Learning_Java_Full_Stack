import { Component } from '@angular/core';

@Component({
  selector: 'app-topic-1',
  templateUrl: './topic-1.component.html',
  styleUrl: './topic-1.component.css'
})
export class Topic1Component {

  name='Angular Learning';

  today=new Date();

  price=100;

  percentage = 0.653;

  message = 'Angular Learning'

}
