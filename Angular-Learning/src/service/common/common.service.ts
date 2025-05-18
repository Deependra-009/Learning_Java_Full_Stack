import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CommonService {

  constructor() { }

  getSvgIcon(key:string){
    switch(key){
      case 'COPIED': return 'assets/svg/copy-check.svg';
      case 'COPY':return 'assets/svg/copy.svg';
      default:return''
    }
  }
}
