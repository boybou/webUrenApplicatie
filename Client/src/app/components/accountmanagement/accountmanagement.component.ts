
import { Component, OnInit } from '@angular/core';
import {Employee} from "../../models/Employee";
import {LoginData} from "../../models/LoginData";
import {ApiService} from "../../shared/api.service";
import {CompleteUser} from "../../models/CompleteUser";
import {PasswordcheckerService} from "../../shared/PasswordChecker.service";
import {Observable} from "rxjs/Observable";

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
      console.log(this.completeUser.employee_Role_Name);

      // console.log("email is" + this.checkEmailExists(this.completeUser.email));
      // if(this.checkEmailExists(this.completeUser.email)){
      //   console.log("AlreadyEmail")
      //
      // }else{
      //   console.log("nog geen email")
      // }

      this.completeUser.employee_Active = true;

      let message = this.pwChecker.checkPassword(this.completeUser.password,this.checkPassword)
      console.log(message);
      if(message == this.pwChecker.succesfull){
        console.log("Succes")
        this.completeUser.employee_Type_Name = "intern"
        let uri = "/api/users/insertlogindata";
        this.api.post(uri,this.completeUser).subscribe();
        this.errorMessageNewUser = "";
        this.succesMessageNewUser = this.pwChecker.succesfull;
      }else{
        console.log("fail")
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
    console.log(this.completeUser.employee_Firstname)
      if(this.completeUser.employee_Firstname == null || this.completeUser.employee_Lastname == null|| this.completeUser.email ==null || this.completeUser.password == null|| this.completeUser == null){
        console.log("iets is leeg")
        return false;
      }else{
        console.log("alles is vol")
        return true;
      }

  }

  private checkEmailExists(email: string) {
    let uri = "/api/users/getLoginData" + email;
    this.api.get<LoginData>(uri).subscribe( data =>{
      let testLoginData:LoginData = data;
      if(testLoginData != null){
        console.log("True");
        return true;
      }else{
        console.log("False");
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
    console.log("in change password")
    console.log(this)
    let loginData:LoginData = new LoginData;
    loginData.password = this.passwordToUpdate;
    loginData.email = this.emailToUpdate;
    let message = this.pwChecker.checkPassword(this.passwordToUpdate,this.checkPasswordToUpdate);
    if(message == this.pwChecker.succesfull){
    let uri = "/api/users/updateLoginData"
    this.api.post(uri,loginData).subscribe();
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
