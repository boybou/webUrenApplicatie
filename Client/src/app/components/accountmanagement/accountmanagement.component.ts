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

  private employee:Employee = new Employee;
  private loginData:LoginData = new LoginData;
  private checkPassword:string;
  private isAddAccount : boolean = true;
  private isChangePassword : boolean = false;
  private errorMessage : string;

  completeUser:CompleteUser;
  constructor(private api:ApiService) { }

  ngOnInit() {
    this.completeUser = new CompleteUser();
  }

  public insertUser() {
    console.log("in insert user")
    this.completeUser.employee_Active = true;
    console.log("insert user " + this.completeUser.employee_Firstname);
    let uri = "/api/users/insertlogindata";
    this.api.post(uri,this.completeUser).subscribe();

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
