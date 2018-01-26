import { Component, OnInit } from '@angular/core';
import {IncompleteHour} from "../../models/IncompleteHour";
import {ApiService} from "../../shared/api.service";
import {AuthorisationService} from "../../shared/authorisation.service";
import {StatisticsModel} from "../../models/StatisticsModel";
import {StatisticReturn} from "../../models/StatisticReturn";
import {applySourceSpanToExpressionIfNeeded} from "@angular/compiler/src/output/output_ast";
import {StaticUri} from "../../models/StaticUri";


@Component({
  selector: 'app-statisticts',
  templateUrl: './statisticts.component.html',
  styleUrls: ['./statisticts.component.css']
})
export class StatisticsComponent{

  public statistic:StatisticsModel = new StatisticsModel();
  public statisticReturn:StatisticReturn;
  public returned:boolean = false;
  constructor(private api:ApiService) {

  }

  sendStatistics() {



    // let uri = "/api/statistics/sendStatistics";
    // this.api.post(uri,this.statistic).subscribe(data =>{
    //     console.log("verzonden");
    //     this.statistic = new StatisticsModel();
    //     this.retreiveStatistics()
    //
    //   }
    //   ,error =>{
    //     console.log(error.error,error.name,error.status)
    //   }
    // );
    this.retreiveStatistics();




  }

  retreiveStatistics()
  {
    this.api.get<StatisticReturn>(StaticUri.getStatistics(this.statistic.werknemer,this.statistic.project,this.statistic.subproject)).subscribe(data =>{
      this.statisticReturn = data;
      this.returned = true;
      this.fillP();
      this.statistic = new StatisticsModel();
    });



  }




  fillP()
  {
    console.log(this.statisticReturn.employee);

    console.log(this.statisticReturn.project);

    console.log(this.statisticReturn.subproject);
    console.log(this.statisticReturn.hours);
    console.log(this.statisticReturn.minutes);


  }




}
