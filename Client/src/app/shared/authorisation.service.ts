import {OnInit} from "@angular/core";
import {HttpHeaders} from "@angular/common/http";
import {AppComponent} from "../app.component";



export class AuthorisationService implements OnInit{
  ngOnInit() {

  }

  public static header:HttpHeaders = new HttpHeaders();
  public static employeeNumber:number;
  public static isLoggedIn:boolean = false;

  public setHeader(emailAddress: string, password: string){
    let authString = 'Basic ' + btoa(emailAddress+':'+ password);
    AuthorisationService.header = AuthorisationService.header.set('Authorization',authString);

  }
  public retrieveCookie(){
    AuthorisationService.header = AuthorisationService.header.set('Authorization',AppComponent.cookieService.get('header'));
    AuthorisationService.employeeNumber = Number(AppComponent.cookieService.get('employeeNumber'))
  }

  public saveCookie(){
    AppComponent.cookieService.set('header',AuthorisationService.header.get('Authorization'));
    AppComponent.cookieService.set('employeeNumber',String(AuthorisationService.employeeNumber));
  }
  public logout(){
    AppComponent.cookieService.deleteAll();
    AuthorisationService.header = new HttpHeaders();
    AuthorisationService.employeeNumber = null;
    AuthorisationService.isLoggedIn = false;
  }



}
