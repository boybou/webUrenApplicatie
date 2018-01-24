import { Component } from '@angular/core';
import {ApiService} from "../../shared/api.service";
import {IncompleteHour} from "../../models/IncompleteHour";
import {AuthorisationService} from "../../shared/authorisation.service";
import {StaticUri} from "../../models/StaticUri";

@Component({
    selector: 'hour-form',
    templateUrl: './hour.component.html',
    styleUrls: ['./hour.component.css']
})

export class Hour{

  public hour:IncompleteHour = new IncompleteHour();
  private errorMessage:string;
  constructor(private api:ApiService ){

  }
  sendHour() {
    if (this.checkFieldsComplete()){
    this.hour.hour_employee_number = AuthorisationService.employeeNumber;
    var inputValue = (<HTMLInputElement>document.getElementById("dateFormat")).value;
    this.hour.date_format = this.parseDateFormat(inputValue);
    this.api.post(StaticUri.insertHour,this.hour).subscribe(data =>{
        this.hour = new IncompleteHour();
    }
      ,error =>{
        console.log("internal server error")
      }
    );
    this.errorMessage = ""
    }else{
      this.errorMessage = "Vul alle velden in"

    }


  }

  private checkFieldsComplete() {
    if (this.hour.hour_subproject_name != null && this.hour.hour_client != null && this.hour.hour_project_name != null && this.hour.startTime != null && this.hour.endTime && this.hour.hour_comments != null && this.hour.hour_date != null){

      return true
    }else {
      return false
    }

  }
  private parseDateFormat(date) {
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
