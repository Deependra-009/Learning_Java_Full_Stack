import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Solution1Component } from '../../pages/solutions/solution-1/solution-1.component';
import { Solution2Component } from '../../pages/solutions/solution-2/solution-2.component';



@NgModule({
  declarations: [
    Solution1Component,
    Solution2Component
  ],
  imports: [
    CommonModule
  ]
})
export class SolutionsModule { }
