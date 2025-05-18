import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedModule } from '../modules/shared/shared.module';
import { RouterOutlet } from '@angular/router';
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule,SharedModule,RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Angular-Learning';
  value = 'Clear me';

  test(){
    console.log("hello");

  }
  setValue(val:any){
    this.value=val;
  }


}
