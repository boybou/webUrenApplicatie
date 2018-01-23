import { Component, OnInit } from '@angular/core';
import {IncompleteHour} from "../../models/IncompleteHour";
import {ApiService} from "../../shared/api.service";
import {AuthorisationService} from "../../shared/authorisation.service";
import {StatisticsModel} from "../../models/StatisticsModel";
import {StatisticReturn} from "../../models/StatisticReturn";
import {applySourceSpanToExpressionIfNeeded} from "@angular/compiler/src/output/output_ast";
import {UriInof} from "../../models/UriInfo";


@Component({
  selector: 'app-statisticts',
  templateUrl: './statisticts.component.html',
  styleUrls: ['./statisticts.component.css']
})
export class StatisticsComponent{

  public statistic:StatisticsModel = new StatisticsModel();
  public statisticReturn:StatisticReturn;
  constructor(private api:ApiService) {

  }

  sendStatistics() {

    console.log("in send statistics");

    this.api.post(UriInof.sendStatistics,this.statistic).subscribe(data =>{
        console.log("verzonden");
        this.statistic = new StatisticsModel();
      }
      ,error =>{
        console.log(error.error,error.name,error.status)
      }
    );


    this.retreiveStatistics()


  }

  retreiveStatistics()
  {
    console.log("getStatistics");

    let uri = "/api/statistics/getStatistics";
    this.api.get<StatisticReturn>(uri).subscribe(data =>{
      this.statisticReturn = data;
    });

    this.fillP();

  }




  fillP()
  {
    console.log(this.statisticReturn.employee);

    // console.log(this.statisticReturn.project);
    // if(this.statisticReturn.project != null)
    // {
    //   document.getElementById("projectR").innerText = this.statisticReturn.project;
    // }
    // console.log(this.statisticReturn.subproject);
    // console.log(this.statisticReturn.hours);
    // console.log(this.statisticReturn.minutes);
  }




}
