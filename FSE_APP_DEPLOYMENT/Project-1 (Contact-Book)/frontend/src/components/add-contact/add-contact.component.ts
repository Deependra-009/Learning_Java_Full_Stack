import { Component } from '@angular/core';
import { CommonService } from '../../services/common.service';
import { ContactRequestBean, ContactResponseBean } from '../../interface/CommonModels';
import { FormsModule } from '@angular/forms';
import { CommonRepositoryService } from '../../repository/common-repository.service';

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
    private commonService:CommonService,
    private commonRepository:CommonRepositoryService
  ){}

  generateRandomIndianContact(){
    this.contactData = this.commonService.generateRandomIndianContact();
  }

  addContact(){
    console.log(this.contactData);
    this.commonRepository.addContact(this.contactData).subscribe((data:any)=>{
      console.log(data);
      this.contactData={
        name:'',
        phoneNumber:''
      }
      this.commonRepository.updateContactList.next(data);

    })

  }



}
