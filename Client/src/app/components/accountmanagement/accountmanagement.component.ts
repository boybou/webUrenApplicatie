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

  private employee:Employee = new Employee;
  private loginData:LoginData = new LoginData;
  private checkPassword:string;
  private isAddAccount : boolean = true;
  private isChangePassword : boolean = false;
  private errorMessage : string;

  constructor(private api:ApiService) { }

  ngOnInit() {
  }

  public insertUser() {
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

  public setIsAddAccount(){
    this.isAddAccount = true;
    this.isChangePassword = false;
  }

  public setIsChangePassword(){
    this.isAddAccount = false;
    this.isChangePassword = true;
  }

  private showErrorMessagePassword(){
    this.errorMessage = "Wachtwoorden matchen niet";
  }

  private showErrorMessageEmptyField(){
    this.errorMessage = "Vul alle velden in";
  }

  private showErrorMessageWrongEmail(){
    this.errorMessage = "Emailadres is niet bekend"
  }

  public changePassword(){
  }
}
