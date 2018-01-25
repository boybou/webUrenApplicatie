
import { Component, OnInit } from '@angular/core';
import {Employee} from "../../models/Employee";
import {LoginData} from "../../models/LoginData";
import {ApiService} from "../../shared/api.service";
import {CompleteUser} from "../../models/CompleteUser";
import {PasswordcheckerService} from "../../shared/PasswordChecker.service";
import {Observable} from "rxjs/Observable";
import {StaticUri} from "../../models/StaticUri";

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
  private emailToUpdate: string;
  private passwordToUpdate: string;
  private checkPasswordToUpdate: string;
  completeUser:CompleteUser;
  succesMessage: string;
  errorMessageNewUser: string;
  succesMessageNewUser: string;
  notAllFieldsFilled : string = "Niet alle velden ingevuld";
  constructor(private api:ApiService, private pwChecker:PasswordcheckerService) { }

  ngOnInit() {
    this.completeUser = new CompleteUser();

  }

  public insertUser() {
    if (this.allNewUserFieldsFilled()){
      this.errorMessageNewUser = "";
      this.succesMessageNewUser = "";


      // console.log("email is" + this.checkEmailExists(this.completeUser.email));
      // if(this.checkEmailExists(this.completeUser.email)){
      //   console.log("AlreadyEmail")
      //
      // }else{
      //   console.log("nog geen email")
      // }

      this.completeUser.employee_Active = true;

      let message = this.pwChecker.checkPassword(this.completeUser.password,this.checkPassword)
      if(message == this.pwChecker.succesfull){
        this.completeUser.employee_Type_Name = "intern"
        this.api.post(StaticUri.insertLoginData,this.completeUser).subscribe();
        this.errorMessageNewUser = "";
        this.succesMessageNewUser = this.pwChecker.succesfull;
      }else{
        this.errorMessageNewUser = message;
        this.succesMessageNewUser = "";
      }
    }else{
      this.succesMessageNewUser = "";
      this.errorMessageNewUser = this.notAllFieldsFilled
    }

  }
//
  private allNewUserFieldsFilled() {
      if(this.completeUser.employee_Firstname == null || this.completeUser.employee_Lastname == null|| this.completeUser.email ==null || this.completeUser.password == null|| this.completeUser == null){
        return false;
      }else{
        return true;
      }

  }

  private checkEmailExists(email: string) {
    this.api.get<LoginData>(StaticUri.getLoginDataByEmail(email)).subscribe(data =>{
      let testLoginData:LoginData = data;
      if(testLoginData != null){
        return true;
      }else{
        return false;
      }

    });

  }


  public setIsAddAccount(){
    this.isAddAccount = true;
    this.isChangePassword = false;
  }

  public setIsChangePassword(){
    this.isAddAccount = false;
    this.isChangePassword = true;
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
    if(this.allChangePasswordFieldsFilled()){
    let loginData:LoginData = new LoginData;
    loginData.password = this.passwordToUpdate;
    loginData.email = this.emailToUpdate;
    let message = this.pwChecker.checkPassword(this.passwordToUpdate,this.checkPasswordToUpdate);
    if(message == this.pwChecker.succesfull){
    this.api.put(StaticUri.updateLoginData,loginData).subscribe();
    this.errorMessage = "";
    this.succesMessage = message;
    }else {
      this.errorMessage = message;
      this.succesMessage = "";
    }

  }else{
      this.errorMessage = this.notAllFieldsFilled
    }
  }

  private allChangePasswordFieldsFilled() {
    if(this.emailToUpdate == null || this.passwordToUpdate == null || this.checkPasswordToUpdate == null){
      return false
    }else{
      return true
    }
  }


}
