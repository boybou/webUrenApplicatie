import {OnInit} from "@angular/core";
import {HttpHeaders} from "@angular/common/http";
import {AppComponent} from "../app.component";



export class AuthorisationService implements OnInit{
  ngOnInit() {

  }

  public static header:HttpHeaders = new HttpHeaders();
  public static role:string = "";
  public static employeeNumber:number;
  public static isLoggedIn:boolean = false;
  public static email : string;

  public setHeader(emailAddress: string, password: string){
    let authString = 'Basic ' + btoa(emailAddress+':'+ password);
    AuthorisationService.email = emailAddress;
    AuthorisationService.header = AuthorisationService.header.set('Authorization',authString);

  }
  public retrieveCookie(){
    AuthorisationService.header = AuthorisationService.header.set('Authorization',AppComponent.cookieService.get('header'));
    AuthorisationService.employeeNumber = Number(AppComponent.cookieService.get('employeeNumber'));
    AuthorisationService.email = AppComponent.cookieService.get('email');
    AuthorisationService.role = AppComponent.cookieService.get('role');
  }

  public saveCookie(){
    AppComponent.cookieService.set('role',AuthorisationService.role);
    AppComponent.cookieService.set('email', AuthorisationService.email);
    AppComponent.cookieService.set('header',AuthorisationService.header.get('Authorization'));
    AppComponent.cookieService.set('employeeNumber',String(AuthorisationService.employeeNumber));
  }
  public logout(){
    AppComponent.cookieService.deleteAll();
    AuthorisationService.role = "";
    AuthorisationService.header = new HttpHeaders();
    AuthorisationService.employeeNumber = null;
    AuthorisationService.isLoggedIn = false;
  }



}
