import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Topic1Component } from '../../../pages/topics/topic-1/topic-1.component';
import { CodingCardComponent } from '../../../components/reusable/coding-card/coding-card.component';
import { AddPrefixPipe } from '../../../pages/topics/topic-1/AddPrefixPipe/add-prefix.pipe';



@NgModule({
  declarations: [
    Topic1Component,
    CodingCardComponent,

  ],
  imports: [
    CommonModule,
    AddPrefixPipe,

  ]
})
export class TopicsModule { }
