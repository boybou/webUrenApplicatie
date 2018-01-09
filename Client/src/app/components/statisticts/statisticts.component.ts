import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-statisticts',
  templateUrl: './statisticts.component.html',
  styleUrls: ['./statisticts.component.css']
})
export class StatistictsComponent implements OnInit {

  constructor() {

  }

  ngOnInit() {

  }


 add(text){
    console.log(text);
   var hoursoff = text;

  }

}
