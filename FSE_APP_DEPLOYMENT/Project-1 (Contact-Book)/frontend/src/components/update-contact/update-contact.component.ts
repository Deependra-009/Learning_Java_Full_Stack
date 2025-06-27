import { Component, OnInit } from '@angular/core';
import {
  ContactRequestBean,
  ContactResponseBean,
} from '../../interface/CommonModels';
import { CommonRepositoryService } from '../../repository/common-repository.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-update-contact',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './update-contact.component.html',
  styleUrl: './update-contact.component.css',
})
export class UpdateContactComponent implements OnInit {
  contactData: ContactResponseBean = {
    id: 0,
    name: '',
    phoneNumber: '',
  };

  ngOnInit(): void {
    this.commonService.shareContact$.subscribe((data:ContactResponseBean | null)=>{
      console.log("==>",data);

      if(data!=null){
        this.contactData=data
      }
    })
  }



  constructor(private commonService: CommonRepositoryService) {}

  updateContact() {
    this.commonService.updateContact(this.contactData).subscribe(()=>{
      // console.log("=>",data);
      this.commonService.showUpdateContact.next(false);

    })
  }
}
