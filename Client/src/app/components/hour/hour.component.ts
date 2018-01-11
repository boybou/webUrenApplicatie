import {Component, Input, OnInit} from '@angular/core';
import {CompleteHour} from "../../models/CompleteHour";

@Component({
  selector: 'app-hour',
  templateUrl: './hour.component.html',
  styleUrls: ['./hour.component.css']
})
export class HourComponent implements OnInit {
  @Input('completeHour') completeHour:CompleteHour;
  private red:string = "disapproved";
  private green:string = "approved";
  private yellow:string = "pending";

  constructor() { }

  ngOnInit() {
    console.log(this.completeHour.hour_client_name,this.completeHour.startTime,this.completeHour.endTime)

  }


}
