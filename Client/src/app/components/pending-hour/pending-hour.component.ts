import {Component, Input, OnInit} from '@angular/core';
import {Hour} from "../../models/Hour";
import {ApiService} from "../../shared/api.service";
import {CompleteHour} from "../../models/CompleteHour";
import {UriInof} from "../../models/UriInfo";

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
    this.api.put(UriInof.approveHour(this.hour.id)).subscribe(data =>{
    },error =>{
      console.log("iest fout")
      }
    )
    document.getElementById('card').parentNode.removeChild(document.getElementById('card'))

  }
  disapproveHour(){
    this.api.put(UriInof.disapproveHour(this.hour.id)).subscribe(data =>{
      },error =>{
        console.log("iest fout")
      }
    )
    document.getElementById('card').parentNode.removeChild(document.getElementById('card'))
  }

}
