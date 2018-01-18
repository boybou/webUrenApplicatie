import {Component, OnInit} from '@angular/core';
import { Authorization } from '../sharedComponent/authorization.serve'
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {IncompleteHour} from "../../models/IncompleteHour";
import {Hour} from "../hourcomponent/hour.component";
import {Observable} from "rxjs/Observable";
import {LoginData} from "../../models/LoginData";
import {Router} from "@angular/router";
import {AuthorisationService} from "../../shared/authorisation.service";
import {ApiService} from "../../shared/api.service";
import {Employee} from "../../models/Employee";
import {UriInof} from "../../models/UriInof";


@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class Login{
  private emailAddress:string;
  private password:string;
    constructor(private router: Router,private auth: AuthorisationService, private api: ApiService) {
  }


  loginButton(){
      this.auth.setHeader(this.emailAddress,this.password);
      this.login();


  }
  ngOnInit(){
    this.auth.retrieveCookie();
    this.login()

  }
  private login(){
    let uri = "/api/users/me";
    this.api.get<LoginData>(uri).subscribe(data => {
      let loginData:LoginData = data;
      AuthorisationService.employeeNumber = loginData.employeeNumber;
      this.auth.saveCookie();
      AuthorisationService.isLoggedIn = true;
      if(AuthorisationService.isLoggedIn) {
        this.router.navigate(['/hourOverview'])
      }
      this.api.get<Employee>(UriInof.getEmployee(loginData.employeeNumber)).subscribe(data =>{
        AuthorisationService.role = data.employee_Role_Name;
      })
    },error =>{
      console.log("inloggen mislukt");
    })
  }


}
