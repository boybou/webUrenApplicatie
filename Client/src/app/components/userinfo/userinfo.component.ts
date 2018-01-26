import {Component, Inject, OnInit} from '@angular/core';
import {ApiService} from "../../shared/api.service";
import {Router} from "@angular/router";
import {AuthorisationService} from "../../shared/authorisation.service";
import {Employee} from "../../models/Employee";
import {LoginData} from "../../models/LoginData";
import {StaticUri} from "../../models/StaticUri";
import {PasswordcheckerService} from "../../shared/PasswordChecker.service";


@Component({
  selector: 'app-userinfo',
  templateUrl: './userinfo.component.html',
  styleUrls: ['./userinfo.component.css']
})
export class UserinfoComponent implements OnInit {
  public loginData : LoginData = new LoginData();
  private emp : Employee;
  private email : string;
  private checkPassword: string;
  private errorMessageChangePW: string;
  private succesMessageChangePW:string;
  private passwordIncorrect: string = "Wachtwoord incorrect";
  private oldPassword : string;

  constructor(private api : ApiService, private rout : Router, private auth : AuthorisationService, private pwChecker:PasswordcheckerService) { }


  ngOnInit() {
    this.email = AuthorisationService.email;
    this.getUserInformation();
  }

  private getUserInformation() {
    let uri = "/api/employee/" + AuthorisationService.employeeNumber;
    this.api.get<Employee>(uri).subscribe(data => {
        console.log("employee data ", data)
        let employee = data;
        this.emp = employee;
      }
      , error => {
        console.log(error.error, error.name, error.status)
      }
    );
  }

  public changePassword(){


      this.loginData.email = AuthorisationService.email;
      this.loginData.employeeNumber = AuthorisationService.employeeNumber;

      this.api.get(StaticUri.getSelf).subscribe( data =>{
       let tempLoginData:LoginData = data;
       if(tempLoginData.password == this.oldPassword){
        let messageChangePW:string = this.pwChecker.checkPassword(this.loginData.password, this.checkPassword);
        if (messageChangePW == this.pwChecker.succesfull){

          this.api.put(StaticUri.updateLoginData,this.loginData).subscribe();
          this.succesMessageChangePW = messageChangePW;
          this.errorMessageChangePW = "";

        }else{
          this.succesMessageChangePW = "";
          this.errorMessageChangePW = messageChangePW;
        }
       }else{
         this.succesMessageChangePW = "";
         this.errorMessageChangePW = this.passwordIncorrect;
       }
      })
    }

  }
