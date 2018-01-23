import { Component, OnInit } from '@angular/core';
import {Hour} from "../../models/Hour";
import {ApiService} from "../../shared/api.service";
import {CompleteHour} from "../../models/CompleteHour";
import {UriInof} from "../../models/UriInfo";

@Component({
  selector: 'app-hourapproval',
  templateUrl: './hourapproval.component.html',
  styleUrls: ['./hourapproval.component.css']
})
export class HourapprovalComponent implements OnInit {

  private hours : Hour[];

  constructor(private api:ApiService) {

  }

  ngOnInit() {
    this.getPendingHours()
  }
  getPendingHours() {
    console.log("in construct")

    this.api.get<Hour[]>(UriInof.getPendingHours).subscribe( data =>{
      let temp_hours : Hour[] = data;
      this.hours = temp_hours;
      console.log(this.hours[0].hour_comments);
    })

  }
  printhour1(){
    console.log(this.hours[0].hour_subproject_number + "test");
  }

}
