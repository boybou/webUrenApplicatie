import {Component, Input, OnInit} from '@angular/core';
import {CalendarDate} from "../../models/CalendarDate";

@Component({
  selector: 'app-day',
  templateUrl: './day.component.html',
  styleUrls: ['./day.component.css']
})
export class DayComponent implements OnInit {
  @Input('date') date: CalendarDate;
  dayTitle:String;
  constructor() {
  }

  ngOnInit(){
    this.generateTitle();
  }

  private generateTitle() {
    this.dayTitle = this.date.dayName + "\n" + this.date.day + "/" + (this.date.month) + "/" + this.date.year;
    console.log("Dat titel " + this.dayTitle)
  }

}


