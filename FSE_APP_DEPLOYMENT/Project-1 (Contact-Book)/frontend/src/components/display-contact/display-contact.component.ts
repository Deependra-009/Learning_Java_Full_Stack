import { CommonModule } from '@angular/common';
import { Component, inject, OnInit } from '@angular/core';
import { CommonRepositoryService } from '../../repository/common-repository.service';
import { ContactResponseBean } from '../../interface/CommonModels';

@Component({
  selector: 'app-display-contact',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './display-contact.component.html',
  styleUrl: './display-contact.component.css'
})
export class DisplayContactComponent implements OnInit {


  constructor(
    private commonService:CommonRepositoryService,
  ){}

  ngOnInit(): void {
    this.commonService.getAllContact().subscribe((data:any)=>{
      this.allContactList=data;
    })

    this.commonService.updateContactList.subscribe((data:ContactResponseBean)=>{
      this.allContactList.push(data);
    })
  }



  allContactList=new Array<ContactResponseBean>();

  getAllContacts(){
    this.commonService.getAllContact().subscribe((data:any)=>{
      this.allContactList=data;
    })
  }

  deleteContact(id:number){
    this.allContactList=this.allContactList.filter((contact:ContactResponseBean)=>contact.id !=id);
    this.commonService.deleteContact(id).subscribe((data:any)=>{
      console.log(data);

    })
  }

  updateContact(item:ContactResponseBean){
    console.log("ava",item);
    this.commonService.showUpdateContact.next(true);
    this.commonService.setShareContact(item);

  }

}
