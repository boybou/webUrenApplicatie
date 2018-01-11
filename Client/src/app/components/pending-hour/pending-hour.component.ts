import {Component, Input, OnInit} from '@angular/core';
import {Hour} from "../../models/Hour";
import {ApiService} from "../../shared/api.service";

@Component({
  selector: 'app-pending-hour',
  templateUrl: './pending-hour.component.html',
  styleUrls: ['./pending-hour.component.css']
})
export class PendingHourComponent implements OnInit {
@Input("hour") hour:Hour;
  constructor(private api : ApiService) { }

  ngOnInit() {
  }
  approveHour(){
    let uri = "/api/hour/approveHour" + this.hour.id;
    this.api.get(uri).subscribe(data =>{
      this.deleteThisElement()
    },error =>{
      console.log("iest fout")
      }
    )


  }
  disapproveHour(){
    let uri = "/api/hour/disapproveHour" + this.hour.id;
    this.api.get(uri).subscribe(data =>{
        this.deleteThisElement()
      },error =>{
        console.log("iest fout")
      }
    )
  }
  deleteThisElement(){
    document.getElementById("pending").parentNode.removeChild(document.getElementById("pending"));
  }

}
