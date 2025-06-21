import { Component } from '@angular/core';

@Component({
  selector: 'app-topic-2',
  templateUrl: './topic-2.component.html',
  styleUrl: './topic-2.component.css'
})
export class Topic2Component {


  displayBox1=true;
  displayBox2=false;

  itemsArray=[
    'Item 1',
    'Item 2',
    'Item 3',
    'Item 4',
    'Item 5'
  ]

}
