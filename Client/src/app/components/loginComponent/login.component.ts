import { Component } from '@angular/core';
import { Authorization } from '../sharedComponent/authorization.serve'
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {IncompleteHour} from "../../models/IncompleteHour";
import {Hour} from "../hourcomponent/hour.component";
import {Observable} from "rxjs/Observable";
import {LoginData} from "../../models/LoginData";
import {Router} from "@angular/router";
import {AuthorisationService} from "../../shared/authorisation.service";
import {ApiService} from "../../shared/api.service";


@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class Login {
  private emailAddress:string;
  private password:string;

  public anyArray: any[];
  public isloggedin:boolean = false;


  constructor(private router: Router,private auth: AuthorisationService, private api: ApiService) {
  }


  login(){
      let uri = "/api/users/me";
      this.auth.setHeader(this.emailAddress,this.password);
      this.api.get<LoginData>(uri).subscribe(data => {
        let loginData:LoginData = data;
        console.log(data.password);
        console.log(loginData.password);

        AuthorisationService.employeeNumber = loginData.employeeNumber;
        console.log(AuthorisationService.employeeNumber);
        this.isloggedin = true;
        if(this.isloggedin) {
          this.router.navigate(['/hourOverview'])
        }
      },error =>{
        console.log("inloggen mislukt");
      })




  }
}
