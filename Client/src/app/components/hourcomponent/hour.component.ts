import { Component } from '@angular/core';
import {ApiService} from "../../shared/api.service";
import {IncompleteHour} from "../../models/IncompleteHour";
import {AuthorisationService} from "../../shared/authorisation.service";

@Component({
    selector: 'hour-form',
    templateUrl: './hour.component.html',
    styleUrls: ['./hour.component.css']
})

export class Hour{

  public hour:IncompleteHour = new IncompleteHour();

  constructor(private api:ApiService ){

  }
  sendHour() {
    console.log("in send hour");
    this.hour.hour_employee_number = AuthorisationService.employeeNumber;
    let uri = "/api/hour/inserthour";
    this.api.post(uri,this.hour).subscribe(data =>{
        console.log("verzonden");
        this.hour = new IncompleteHour();
    }
      ,error =>{
        console.log(error.error,error.name,error.status)
      }
    );


  }
}
