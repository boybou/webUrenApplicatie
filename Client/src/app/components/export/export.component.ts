import { Component, OnInit } from '@angular/core';
import {promise} from "selenium-webdriver";
import checkedNodeCall = promise.checkedNodeCall;

@Component({
  selector: 'app-export',
  templateUrl: './export.component.html',
  styleUrls: ['./export.component.css']
})
export class ExportComponent implements OnInit {

  constructor() { }

  ngOnInit() {

  }

  checkifchecked()
  {
    // document.getElementById("test").click();
    // document.getElementById("test2").click();
    let element = <HTMLInputElement> document.getElementById("test");
    if (element.checked)
    {
      document.getElementById("test2").click();
    }
    let element2 = <HTMLInputElement> document.getElementById("test2");
    if (element.checked)
    {
      document.getElementById("test").click();
    }

  }


  openoptions()
  {

  }




}
