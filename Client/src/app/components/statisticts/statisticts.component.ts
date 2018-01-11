import { Component, OnInit } from '@angular/core';
import {IncompleteHour} from "../../models/IncompleteHour";
import {ApiService} from "../../shared/api.service";
import {AuthorisationService} from "../../shared/authorisation.service";
import {StatisticsModel} from "../../models/StatisticsModel";

@Component({
  selector: 'app-statisticts',
  templateUrl: './statisticts.component.html',
  styleUrls: ['./statisticts.component.css']
})
export class StatistictsComponent{

  public statistic:StatisticsModel = new StatisticsModel();
  constructor(private api:ApiService) {

  }

  sendStatistics() {

    console.log("in send statistics");

    let uri = "/api/statistics/sendStatistics";
    this.api.post(uri,this.statistic).subscribe(data =>{
        console.log("verzonden");
        this.statistic = new StatisticsModel();
      }
      ,error =>{
        console.log(error.error,error.name,error.status)
      }
    );


  }








}
