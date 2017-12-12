import { Component } from '@angular/core';
import {ApiService} from "../../shared/api.service";
import {IncompleteHour} from "../../models/IncompleteHour";

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
    console.log("in send hour")
    this.hour.hour_employee_number = 1;
    let uri = "/api/hour/inserthour";
    this.api.post(uri,this.hour).subscribe(
      error =>{
        console.log(error)
      }
    );

  }
}
