import {Component, Inject, OnInit} from '@angular/core';
import {ApiService} from "../../shared/api.service";
import {Router} from "@angular/router";
import {AuthorisationService} from "../../shared/authorisation.service";
import {Employee} from "../../models/Employee";
import {StaticUri} from "../../models/StaticUri";


@Component({
  selector: 'app-userinfo',
  templateUrl: './userinfo.component.html',
  styleUrls: ['./userinfo.component.css']
})
export class UserinfoComponent implements OnInit {

  private emp : Employee;
  private email : string;

  constructor(private api : ApiService, private rout : Router, private auth : AuthorisationService) { }


  ngOnInit() {
    this.email = AuthorisationService.email;
    this.getUserInformation();
  }

  private getUserInformation(){
    this.api.get<Employee>(StaticUri.getEmployee(AuthorisationService.employeeNumber)).subscribe(data =>{
        console.log("employee data ", data)
        let employee = data;
        this.emp = employee;
      }
      ,error =>{
        console.log(error.error,error.name,error.status)
      }
    );
  }
}
