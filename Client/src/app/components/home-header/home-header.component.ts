import { Component, OnInit } from '@angular/core';
import {AuthorisationService} from "../../shared/authorisation.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-home-header',
  templateUrl: './home-header.component.html',
  styleUrls: ['./home-header.component.css']
})
export class HomeHeaderComponent implements OnInit {

  private userName : string;

  constructor(private auth : AuthorisationService, private router : Router) { }

  ngOnInit() {

  }

  logout(){
    this.auth.logout();
    this.router.navigate(['/']);
  }
  getUsername(){
    return AuthorisationService.email;

  }
}
