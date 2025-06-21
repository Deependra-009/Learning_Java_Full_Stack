import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Topic1Component } from '../../../pages/topics/topic-1/topic-1.component';
import { CodingCardComponent } from '../../../components/reusable/coding-card/coding-card.component';
import { AddPrefixPipe } from '../../../pages/topics/topic-1/AddPrefixPipe/add-prefix.pipe';
import { Topic2Component } from '../../../pages/topics/topic-2/topic-2.component';
import { HighlightDirective } from '../../../pages/topics/topic-2/addHighlight/highlight.directive';



@NgModule({
  declarations: [
    Topic1Component,
    Topic2Component,
    CodingCardComponent,

  ],
  imports: [
    CommonModule,
    AddPrefixPipe,
    HighlightDirective

  ]
})
export class TopicsModule { }
