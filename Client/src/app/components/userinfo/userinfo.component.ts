import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {AuthorisationService} from "../../shared/authorisation.service";
import {ApiService} from "../../shared/api.service";
import {Employee} from "../../models/Employee";
import {LoginData} from "../../models/LoginData";

@Component({
  selector: 'app-userinfo',
  templateUrl: './userinfo.component.html',
  styleUrls: ['./userinfo.component.css']
})
export class UserinfoComponent implements OnInit {
  public employee: Employee;
  public loginData: LoginData;
  constructor(private api: ApiService) {

  }

  ngOnInit() {
    let uri: string = '/api/employee/me';
    let uri2: string = '/api/users/me';
    this.api.get<Employee>(uri).subscribe(data => {
      this.employee = data;
    }, error => {console.log('Ophalen mislukt.')});

    this.api.get<LoginData>(uri2).subscribe(data => {
      this.loginData = data;
    },  error => {console.log('Ophalen mislukt.')});
  }

}
