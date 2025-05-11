import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CommonService {

  constructor() { }

  getSvgIcon(key:string){
    switch(key){
      case 'FILE': return 'assets/svg/file.svg';
      case 'DOWN_ARROW':return 'assets/svg/chevron-down.svg';
      case 'FOLDER': return 'assets/svg/folder.svg';
      case 'PLUS':return 'assets/svg/plus.svg';
      case 'DELETE':return 'assets/svg/trash.svg';
      case 'RIGHT_ARROW': return 'assets/svg/chevron-right.svg';
      default:return''
    }
  }
}
