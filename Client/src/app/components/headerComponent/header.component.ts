import { Component } from '@angular/core';
import {AuthorisationService} from "../../shared/authorisation.service";
import {Router} from "@angular/router";

@Component({
  selector: 'custom-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class Header {
    constructor(private auth:AuthorisationService,private router: Router){

    }
    logout(){
      this.auth.logout();
      this.router.navigate(['/']);
    }
    public getisLoggedIn():boolean{
     return AuthorisationService.isLoggedIn;
   }
}
