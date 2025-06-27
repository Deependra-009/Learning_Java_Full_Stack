import { Injectable } from '@angular/core';
import { ContactRequestBean, ContactResponseBean } from '../interface/CommonModels';
import { HttpClient } from '@angular/common/http';
import { SERVICE_URL } from '../services/common.contant';
import { BehaviorSubject, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CommonRepositoryService {

  updateContactList=new Subject<ContactResponseBean>();
  showUpdateContact=new BehaviorSubject<boolean>(false);
  shareContactList=new BehaviorSubject<ContactResponseBean | null>(null);
  shareContact$=this.shareContactList.asObservable();

  constructor(
    private http:HttpClient
  ) { }

  setShareContact(data:ContactResponseBean){
    this.shareContactList.next(data);
  }

  addContact(contactData:ContactRequestBean){
    return this.http.post(`${SERVICE_URL}/add`,contactData);
  }

  getAllContact(){
    return this.http.get(`${SERVICE_URL}/get-all`)
  }

  deleteContact(id:number){
    return this.http.delete(`${SERVICE_URL}/delete/${id}`);
  }

  updateContact(contactData:ContactResponseBean){
    return this.http.put(`${SERVICE_URL}/update/${contactData.id}`,contactData);
  }




}
