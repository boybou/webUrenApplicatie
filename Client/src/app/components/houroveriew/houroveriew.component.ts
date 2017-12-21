import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {ApiService} from "../../shared/api.service";
import {AuthorisationService} from "../../shared/authorisation.service";
import {Hour} from "../../models/Hour";

@Component({
  selector: 'app-houroveriew',
  templateUrl: './houroveriew.component.html',
  styleUrls: ['./houroveriew.component.css']
})
export class HouroveriewComponent implements OnInit {

  constructor(private api: ApiService) { }

  ngOnInit() {
    let uri = "/api/hour/me";
    this.api.get<Hour[]>(uri).subscribe( data=>{
      let total_hour:Hour[] = data;
      console.log(total_hour[0].startTime,total_hour[0].hour_employee_number,total_hour.length);
    })
  }

}
