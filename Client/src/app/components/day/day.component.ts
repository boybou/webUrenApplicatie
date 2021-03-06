import {Component, Input, OnChanges, OnInit} from '@angular/core';
import {CalendarDate} from "../../models/CalendarDate";
import {ApiService} from "../../shared/api.service";
import {StaticUri} from "../../models/StaticUri";
import {CompleteHour} from "../../models/CompleteHour";

@Component({
  selector: 'app-day',
  templateUrl: './day.component.html',
  styleUrls: ['./day.component.css']
})
export class DayComponent implements OnInit {
  @Input('date') date: CalendarDate;

  weekDay:String;
  dateOfWeek: string;

  private hoursRetrieved:boolean = false;
  private completeHourList:CompleteHour[] = [];

  constructor(private api:ApiService) {

  }

  ngOnInit(){
    this.generateTitle();


      this.api.get<CompleteHour[]>(StaticUri.getHourByDate(this.date.toDateString())).subscribe(date =>{
        this.completeHourList = date;
        this.hoursRetrieved = true;
      })


  }

  private generateTitle() {
    this.weekDay = this.date.dayName;
    this.dateOfWeek = this.date.day + "/" + (this.date.month) + "/" + this.date.year;
  }


}


