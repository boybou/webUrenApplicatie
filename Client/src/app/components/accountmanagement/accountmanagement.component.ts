import { Component, OnInit } from '@angular/core';
import {Employee} from "../../models/Employee";
import {LoginData} from "../../models/LoginData";
import {ApiService} from "../../shared/api.service";
import {CompleteUser} from "../../models/CompleteUser";

@Component({
  selector: 'app-accountmanagement',
  templateUrl: './accountmanagement.component.html',
  styleUrls: ['./accountmanagement.component.css']
})
export class AccountmanagementComponent implements OnInit {
  completeUser:CompleteUser;
  checkPassword:string;
  constructor(private api:ApiService) { }

  ngOnInit() {
    this.completeUser = new CompleteUser();
  }

  insertUser() {
    console.log("in insert user")
    this.completeUser.employee_Active = true;
    console.log("insert user " + this.completeUser.employee_Firstname);
    let uri = "/api/users/insertlogindata";
    this.api.post(uri,this.completeUser).subscribe();

  }
}
