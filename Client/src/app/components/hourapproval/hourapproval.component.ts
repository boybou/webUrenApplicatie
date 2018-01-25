import { Component, OnInit } from '@angular/core';
import {Hour} from "../../models/Hour";
import {ApiService} from "../../shared/api.service";
import {CompleteHour} from "../../models/CompleteHour";
import {StaticUri} from "../../models/StaticUri";

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

    this.api.get<Hour[]>(StaticUri.getPendingHours).subscribe(data =>{
      let temp_hours : Hour[] = data;
      this.hours = temp_hours;
    })

  }


}
