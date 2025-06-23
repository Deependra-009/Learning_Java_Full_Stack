import { Injectable } from '@angular/core';
import { ContactRequestBean } from '../interface/CommonModels';
import { firstNames, lastNames } from './common.contant';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CommonService {

  private usernameSubject = new BehaviorSubject<string>('Guest');


  constructor() {}

  /**
   * List of sample Indian first names and last names
   */
  firstNames = firstNames;
  lastNames = lastNames;

  /**
   * Generates a random Indian name from sample data.
   */
  generateRandomIndianName(): string {
    const first = firstNames[Math.floor(Math.random() * firstNames.length)];
    const last = lastNames[Math.floor(Math.random() * lastNames.length)];
    return `${first} ${last}`;
  }

  /**
   * Generates a random Indian phone number starting with 6-9.
   * Format: +91 XXXXXXXXXX
   */
  generateIndianPhoneNumber(): string {
    const startDigit = Math.floor(Math.random() * 4) + 6; // 6, 7, 8, 9
    let number = startDigit.toString();

    for (let i = 0; i < 9; i++) {
      number += Math.floor(Math.random() * 10); // Append remaining digits
    }

    return `+91 ${number}`;
  }

  /**
   * Generates a complete contact with random name and Indian phone number.
   */
  generateRandomIndianContact(): ContactRequestBean {
    return {
      name: this.generateRandomIndianName(),
      phoneNumber: this.generateIndianPhoneNumber(),
    };
  }
}
