import { Component, OnInit } from '@angular/core';
import {LoginData} from "../../models/LoginData";
import {ApiService} from "../../shared/api.service";
import {AuthorisationService} from "../../shared/authorisation.service";

@Component({
  selector: 'app-user-password',
  templateUrl: './user-password.component.html',
  styleUrls: ['./user-password.component.css']
})
export class UserPasswordComponent implements OnInit {
  private loginData : LoginData;
  constructor(private api: ApiService) {

  }

  ngOnInit() {
    this.changePassword();
  }

  public changePassword(){
    let uri: string = '/api/loginData/me'
    this.loginData.employeeNumber = AuthorisationService.employeeNumber;

    this.api.post(uri, this.loginData).subscribe(data => {
      this.loginData = new LoginData();
    }, error => {console.log('updaten mislukt.')});
  }
}
