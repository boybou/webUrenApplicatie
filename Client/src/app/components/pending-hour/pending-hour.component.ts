import {Component, Input, OnInit} from '@angular/core';
import {Hour} from "../../models/Hour";
import {ApiService} from "../../shared/api.service";
import {CompleteHour} from "../../models/CompleteHour";
import {StaticUri} from "../../models/StaticUri";

@Component({
  selector: 'app-pending-hour',
  templateUrl: './pending-hour.component.html',
  styleUrls: ['./pending-hour.component.css']
})
export class PendingHourComponent implements OnInit {
@Input("hour") hour: Hour;
  constructor(private api : ApiService) { }

  ngOnInit() {
  }
  approveHour(){
    this.api.put(StaticUri.approveHour(this.hour.id)).subscribe(data =>{
    },error =>{
      console.log("iets fout")
      }
    )
    document.getElementById('card').parentNode.removeChild(document.getElementById('card'))

  }
  disapproveHour(){
    this.api.put(StaticUri.disapproveHour(this.hour.id)).subscribe(data =>{
      },error =>{
        console.log("iets fout")
      }
    )
    document.getElementById('card').parentNode.removeChild(document.getElementById('card'))
  }

}
