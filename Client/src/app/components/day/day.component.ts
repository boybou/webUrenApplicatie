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

    this.api.get<CompleteHour[]>(UriInof.getHourByDate+this.date.toDateString()).toPromise().then(date =>{
      this.completeHourList = date;
      this.hoursRetrieved = true;
    }, error =>{
      console.log(error.error+"shit ging terminaal")
    })


  }

  private generateTitle() {
    this.weekDay = this.date.dayName;
    this.dateOfWeek = this.date.day + "/" + (this.date.month) + "/" + this.date.year;
  }


}


