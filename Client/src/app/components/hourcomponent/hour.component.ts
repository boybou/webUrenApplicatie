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
    var inputValue = (<HTMLInputElement>document.getElementById("dateFormat")).value;
    this.hour.date_format = this.parseDateFormat(inputValue);
    console.log(this.hour.date_format);
    this.api.post(uri,this.hour).subscribe(data =>{
        console.log("verzonden",this.hour.date_format,this.hour.hour_date);
        this.hour = new IncompleteHour();
    }
      ,error =>{
        console.log(error.error,error.name,error.status)
      }
    );


  }
  parseDateFormat(date) {
    let dateFormat = "";
    let yearFound = false;
    let monthFound = false;
    let dayFound = false;
    for (let i in date) {
      console.log(i);
      if (date[i] == "3" && !yearFound) {
        yearFound = true;
        dateFormat += "yyyy-"
      }
      else if (date[i] == "1" && !monthFound) {
        dateFormat += "MM-"
        monthFound = true;
      }
      else if (date[i] == "2" && !dayFound) {
        dateFormat += "dd-"
        dayFound = true;
      }
    }
    dateFormat = dateFormat.slice(0, -1);
    return dateFormat;
  }
}
