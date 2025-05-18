import { Component, ElementRef, ViewChild } from '@angular/core';
import { CommonService } from '../../../service/common/common.service';

@Component({
  selector: 'app-coding-card',
  templateUrl: './coding-card.component.html',
  styleUrl: './coding-card.component.css',
})
export class CodingCardComponent {

  public constructor(
    private commonService:CommonService
  ){}
  @ViewChild('codingcard') codingcard!: ElementRef;

  copySuccess = false;

  copyText() {
    const text = this.codingcard.nativeElement.innerText;

    navigator.clipboard
      .writeText(text)
      .then(() => {
        this.copySuccess = true;
        setTimeout(() => (this.copySuccess = false), 2000);
      })
      .catch((err) => {
        console.error('Copy failed', err);
      });
  }

  getSvgName(key:string){
    return this.commonService.getSvgIcon(key);
  }
}
