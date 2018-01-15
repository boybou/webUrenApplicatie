import { Component, OnInit } from '@angular/core';
import {Employee} from "../../models/Employee";
import {LoginData} from "../../models/LoginData";
import {ApiService} from "../../shared/api.service";

@Component({
  selector: 'app-accountmanagement',
  templateUrl: './accountmanagement.component.html',
  styleUrls: ['./accountmanagement.component.css']
})
export class AccountmanagementComponent implements OnInit {
  employee:Employee = new Employee;
  loginData:LoginData = new LoginData;
  checkPassword:string;
  constructor(private api:ApiService) { }

  ngOnInit() {
  }

  insertUser() {
    console.log("in insert user")
    this.employee.employee_Active = true;
    let uri = "/api/employee/insertemployee"
    this.api.post(uri,this.employee).subscribe();
    console.log("Door emp")
    console.log("voor logindata " + this.loginData.email);
    console.log("voor logindata " + this.loginData.password);
    let loginUri = "/api/users/insertlogindata"
    this.api.post(uri,LoginData).subscribe();
    console.log("Door logindata")
  }
}
