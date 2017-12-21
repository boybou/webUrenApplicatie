import { Component } from '@angular/core';
import { Authorization } from './components/sharedComponent/authorization.serve'
import {CookieService} from "ngx-cookie-service";
import {AuthorisationService} from "./shared/authorisation.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  public static cookieService:CookieService;
  constructor(cookieService:CookieService,private auth:AuthorisationService){
    AppComponent.cookieService = cookieService;

  }
  public getisLoggedIn():boolean{
    return AuthorisationService.isLoggedIn;
  }
}
