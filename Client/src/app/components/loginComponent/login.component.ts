import { Component } from '@angular/core';
import { Authorization } from '../sharedComponent/authorization.serve'
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {hour} from "../../models/hour";
import {Hour} from "../hourcomponent/hour.component";
import {Observable} from "rxjs/Observable";
import {User} from "../../models/User";
import {Router} from "@angular/router";


@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class Login {
  user: User = new User();
  public results: hour;
  public anyArray: any[];
  public isloggedin:boolean = false;


  constructor(private http: HttpClient,private router: Router) {
  }


  login(){
    let headers = new HttpHeaders();
    let authString = 'Basic ' + btoa(this.user.emailAddress+':'+this.user.password);
    headers = headers.set('Authorization',authString);
    // Make the HTTP request:
    this.http.get<User>('/api/users/me', {headers: headers}).subscribe(data => {
      this.isloggedin = true;
      if(this.isloggedin) {
        this.router.navigate(['/hourOverview'])
      }
    },error =>{
      console.log("inloggen mislukt");
    })


  }
}
