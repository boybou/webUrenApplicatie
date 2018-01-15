import {Component, Inject, OnInit} from '@angular/core';
import {ApiService} from "../../shared/api.service";
import {AuthorisationService} from "../../shared/authorisation.service";
import {Employee} from "../../models/Employee";


@Component({
  selector: 'app-userinfo',
  templateUrl: './userinfo.component.html',
  styleUrls: ['./userinfo.component.css']
})
export class UserinfoComponent implements OnInit {


  private employee : Employee;

  constructor(private api:ApiService) { }


  ngOnInit() {
    this.getUserInformation();
  }

  private getUserInformation(){
    console.log("in send hour");
    let uri = "/api/users/" + AuthorisationService.employeeNumber;
    this.api.get<Employee>(uri).subscribe(data =>{
        let employee
      }
      ,error =>{
        console.log(error.error,error.name,error.status)
      }
    );
  }
}
