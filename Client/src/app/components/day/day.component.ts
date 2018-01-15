import {Component, Input, OnChanges, OnInit} from '@angular/core';
import {CalendarDate} from "../../models/CalendarDate";
import {ApiService} from "../../shared/api.service";
import {UriInof} from "../../models/UriInof";
import {CompleteHour} from "../../models/CompleteHour";

@Component({
  selector: 'app-day',
  templateUrl: './day.component.html',
  styleUrls: ['./day.component.css']
})
export class DayComponent implements OnChanges {
  @Input('date') date: CalendarDate;

  weekDay:String;
  dateOfWeek: string;

  private hoursRetrieved:boolean = false;
  private completeHourList:CompleteHour[] = [];

  constructor(private api:ApiService) {

  }

  ngOnChanges(){
    this.generateTitle();

    this.api.get<CompleteHour[]>(UriInof.getHourByDate+this.date.toDateString()).subscribe(date =>{
      this.completeHourList = date;
    }, error =>{
      console.log(error.error+"shit ging terminaal")
    })


  }

  private generateTitle() {
    this.weekDay = this.date.dayName;
    this.dateOfWeek = this.date.day + "/" + (this.date.month) + "/" + this.date.year;
  }

}


