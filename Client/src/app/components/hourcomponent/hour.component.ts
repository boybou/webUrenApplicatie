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
  private errorMessage:string;
  constructor(private api:ApiService ){

  }
  sendHour() {
    var startDate =(<HTMLInputElement>document.getElementById("beginTime")).value;
    console.log("var gebeuren " + startDate)
    console.log((<HTMLInputElement>document.getElementById("beginTime")).value);
    // if (this.checkFieldsComplete()){
    console.log("in send hour");
    this.hour.hour_employee_number = AuthorisationService.employeeNumber;
    let uri = "/api/hour/inserthour";
    var inputValue = (<HTMLInputElement>document.getElementById("dateFormat")).value;
    this.hour.date_format = this.parseDateFormat(inputValue);
    console.log(this.hour.date_format);
    console.log("start" + this.hour.startTime)
    console.log("end" + this.hour.endTime)
    this.api.post(uri,this.hour).subscribe(data =>{
      console.log("in piost")
        console.log("verzonden",this.hour.date_format,this.hour.hour_date);

        this.hour = new IncompleteHour();
    }
      ,error =>{
        console.log(error.error,error.name,error.status)
      }
    );
    this.errorMessage = ""
    // }else{
    //   this.errorMessage = "Vul alle velden in"
    //
    // }


  }

  private checkFieldsComplete() {
    console.log("sub " + this.hour.hour_subproject_name)
    console.log("pro " + this.hour.hour_project_name)
    console.log("comments " + this.hour.hour_comments)
    console.log("client " + this.hour.hour_client)
    console.log("start " + this.hour.startTime)
    console.log("end " + this.hour.endTime)
    console.log("date " + this.hour.hour_date)
    if (this.hour.hour_subproject_name != null && this.hour.hour_client != null && this.hour.hour_project_name != null && this.hour.startTime != null && this.hour.endTime && this.hour.hour_comments != null && this.hour.hour_date != null){
      console.log("Turre complete")
      return true
    }else {
      console.log("False complete")
      return false
    }

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
