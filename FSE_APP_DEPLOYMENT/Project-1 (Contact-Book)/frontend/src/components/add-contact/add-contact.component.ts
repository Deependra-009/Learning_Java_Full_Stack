import { Component } from '@angular/core';
import { CommonService } from '../../services/common.service';
import { ContactRequestBean } from '../../interface/CommonModels';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-add-contact',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './add-contact.component.html',
  styleUrl: './add-contact.component.css'
})
export class AddContactComponent {

  contactData:ContactRequestBean={
    name:'',
    phoneNumber:''
  }

  constructor(
    private commonService:CommonService
  ){}

  generateRandomIndianContact(){
    this.contactData = this.commonService.generateRandomIndianContact();
  }

  addContact(){
    console.log(this.contactData);

  }



}
