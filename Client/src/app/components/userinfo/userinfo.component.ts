import {Component, Inject, OnInit} from '@angular/core';
import {ApiService} from "../../shared/api.service";
import {Router} from "@angular/router";
import {AuthorisationService} from "../../shared/authorisation.service";
import {Employee} from "../../models/Employee";
import {LoginData} from "../../models/LoginData";
import {StaticUri} from "../../models/StaticUri";


@Component({
  selector: 'app-userinfo',
  templateUrl: './userinfo.component.html',
  styleUrls: ['./userinfo.component.css']
})
export class UserinfoComponent implements OnInit {
  public loginData : LoginData = new LoginData();
  private emp : Employee;
  private email : string;

  constructor(private api : ApiService, private rout : Router, private auth : AuthorisationService) { }


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

      let uri = '/api/users/test';
      this.loginData.email = AuthorisationService.email;
      this.loginData.employeeNumber = AuthorisationService.employeeNumber;
      console.log(this.loginData.email)
      console.log(this.loginData.password)
    console.log(this.loginData.employeeNumber)

      this.api.post(uri,this.loginData).subscribe();
      this.loginData = new LoginData();
    }
  }
