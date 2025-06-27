import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { NavbarComponent } from "../components/navbar/navbar.component";
import { AddContactComponent } from "../components/add-contact/add-contact.component";
import { DisplayContactComponent } from "../components/display-contact/display-contact.component";
import { CommonRepositoryService } from '../repository/common-repository.service';
import { UpdateContactComponent } from "../components/update-contact/update-contact.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, NavbarComponent, AddContactComponent, DisplayContactComponent, UpdateContactComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  title = 'frontend';

  showUpdateFlag=false;

  constructor(
    private commonService:CommonRepositoryService
  ){}

  ngOnInit(): void {
    this.commonService.showUpdateContact.subscribe((data:boolean)=>{
      this.showUpdateFlag=data;
    })
  }



}
