import { Component, OnInit } from '@angular/core';
import {CalendarDate} from "../../models/CalendarDate";

@Component({
  selector: 'app-week',
  templateUrl: './week.component.html',
  styleUrls: ['./week.component.css']
})
export class WeekComponent implements OnInit {
  currentWeek:CalendarDate[] = [];
  constructor() { }

  ngOnInit() {
    this.generateWeek();
    this.currentWeek[0]= new CalendarDate(2018,1,18);
    this.currentWeek[1]= new CalendarDate(2018,1,10);
  }

  private generateWeek() {
    var date = new Date(2017,11,14);
    console.log(date)
    while(date.getDay() != 1){
      var n = date.getTime();
      n -= 86400000;
      date = new Date(n);
    }
    console.log(date)
  }

}
