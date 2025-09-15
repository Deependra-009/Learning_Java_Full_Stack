import { Component } from '@angular/core';
import { CommonService } from '../../../service/common/common.service';

@Component({
  selector: 'app-solution-2',
  templateUrl: './solution-2.component.html',
  styleUrl: './solution-2.component.css'
})
export class Solution2Component {

  showPassword=false;
  inputType="password";

  constructor(
    private commonService:CommonService
  ){}

  changeShowPassword(){
    this.showPassword=!this.showPassword;
    this.inputType=this.showPassword?'text':'password';
  }

  getSvgName(key:string){
    return this.commonService.getSvgIcon(key);
  }

}
