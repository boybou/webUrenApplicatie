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
  }

  private generateWeek() {
    let today = new Date();
    let dd = today.getDate();
    let mm = today.getMonth()+1; //January is 0!
    let yyyy = today.getFullYear();
    let date = new CalendarDate(yyyy,mm,dd)
    while (date.dayNumber != 1){
      date.subtractDay()
    }
    for(let i=0;i<7;i++){
      this.currentWeek[i] = new CalendarDate(date.year,date.month,date.day);
      date.addDay();
    }
    console.log()

  }
  nextWeek(){
    let date = new CalendarDate(this.currentWeek[6].year,this.currentWeek[6].month,this.currentWeek[6].day);
    while (date.dayNumber != 1){
      date.addDay()
    }
    for(let i=0;i<7;i++){
      this.currentWeek[i] = new CalendarDate(date.year,date.month,date.day);
      date.addDay();
    }
  }
  preveiousWeek(){
    let date = new CalendarDate(this.currentWeek[0].year,this.currentWeek[0].month,this.currentWeek[0].day);
    date.subtractDay();
    while (date.dayNumber != 1){
      date.subtractDay()
    }
    for(let i=0;i<7;i++){
      this.currentWeek[i] = new CalendarDate(date.year,date.month,date.day);
      date.addDay();
    }
  }

}
