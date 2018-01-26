
import { Component, OnInit } from '@angular/core';
import {Employee} from "../../models/Employee";
import {LoginData} from "../../models/LoginData";
import {ApiService} from "../../shared/api.service";
import {CompleteUser} from "../../models/CompleteUser";
import {PasswordcheckerService} from "../../shared/PasswordChecker.service";
import {Observable} from "rxjs/Observable";
import {StaticUri} from "../../models/StaticUri";
import {log} from "util";

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
  private passwordToUpdate: string;
  private checkPasswordToUpdate: string;
  completeUser:CompleteUser;
  succesMessage: string;
  errorMessageNewUser: string;
  succesMessageNewUser: string;
  notAllFieldsFilled : string = "Niet alle velden ingevuld";
  emailAlreadyInDB : string = "Email bestaat al";
  emailNotInDB : string = "Email bestaat niet"
  errorEmailMessageNewUser: string;
  errorEmailChangePW: string;
  constructor(private api:ApiService, private pwChecker:PasswordcheckerService) { }

  ngOnInit() {
    this.completeUser = new CompleteUser();


  }

  public insertUser() {
    if (this.errorEmailMessageNewUser != this.emailAlreadyInDB) {
      if (this.allNewUserFieldsFilled()) {
        this.errorMessageNewUser = "";
        this.succesMessageNewUser = "";


        this.completeUser.employee_Active = true;

        let message = this.pwChecker.checkPassword(this.completeUser.password, this.checkPassword)
        if (message == this.pwChecker.succesfull) {
          this.completeUser.employee_Type_Name = "intern"
          this.api.post(StaticUri.insertLoginData, this.completeUser).subscribe();
          this.errorMessageNewUser = "";
          this.succesMessageNewUser = this.pwChecker.succesfull;
        } else {
          this.errorMessageNewUser = message;
          this.succesMessageNewUser = "";
        }
      } else {
        this.succesMessageNewUser = "";
        this.errorMessageNewUser = this.notAllFieldsFilled
      }

    }else{
      this.succesMessageNewUser = "";
      this.errorMessageNewUser = this.emailAlreadyInDB;
    }
  }

  private allNewUserFieldsFilled() {
      if(this.completeUser.employee_Firstname == null || this.completeUser.employee_Lastname == null|| this.completeUser.email ==null || this.completeUser.password == null|| this.completeUser == null || this.errorEmailMessageNewUser == this.emailAlreadyInDB){
        return false;
      }else{
        return true;
      }

  }

  private checkEmailExists(email: string) {
    let testLoginData: LoginData = null;
    this.api.get<LoginData>(StaticUri.getLoginDataByEmail(email)).subscribe(data => {
      testLoginData = data;
      if (testLoginData != null) {
        this.errorEmailMessageNewUser = this.emailAlreadyInDB;
        this.errorEmailChangePW = "";

      } else {
        this.errorEmailMessageNewUser = "";
        this.errorEmailChangePW = this.emailNotInDB;
      }

    });




  }

  public setIsAddAccount(){
    this.isAddAccount = true;
    this.isChangePassword = false;
    this.checkEmailInNewUser();
  }

  public setIsChangePassword(){
    this.isAddAccount = false;
    this.isChangePassword = true;
    this.checkEmailInChangePW
  }

  // private showErrorMessagePassword(){
  //   this.errorMessage = "Wachtwoorden matchen niet";
  // }
  //
  // private showErrorMessageEmptyField(){
  //   this.errorMessage = "Vul alle velden in";
  // }
  //
  // private showErrorMessageWrongEmail(){
  //   this.errorMessage = "Emailadres is niet bekend"
  // }

  public changePassword(){
    if(this.errorEmailChangePW != this.emailNotInDB) {
      if (this.allChangePasswordFieldsFilled()) {
        let message = this.pwChecker.checkPassword(this.loginData.password, this.checkPasswordToUpdate);
        if (message == this.pwChecker.succesfull) {

          this.api.put(StaticUri.updateLoginData, this.loginData).subscribe();
          this.errorMessage = "";
          this.succesMessage = message;
        } else {
          this.errorMessage = message;
          this.succesMessage = "";
        }

      } else {
        this.errorMessage = this.notAllFieldsFilled
      }
    }else{
      this.succesMessage = "";
      this.errorMessage = this.emailNotInDB;
    }
  }

  private allChangePasswordFieldsFilled() {
    if(this.loginData.email == null || this.loginData.password == null || this.checkPasswordToUpdate == null){
      return false
    }else{
      return true
    }
  }


  checkEmailInNewUser() {

    this.checkEmailExists(this.completeUser.email)

  }

  checkEmailInChangePW() {

    this.checkEmailExists(this.loginData.email)
  }
}
