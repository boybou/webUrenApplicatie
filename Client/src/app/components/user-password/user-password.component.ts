import { Component, OnInit } from '@angular/core';
import {LoginData} from "../../models/LoginData";
import {ApiService} from "../../shared/api.service";

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

    this.api.get<LoginData>(uri).subscribe(data => {
      this.loginData = data;
    }, error => {console.log('Ophalen mislukt.')});
  }
}
