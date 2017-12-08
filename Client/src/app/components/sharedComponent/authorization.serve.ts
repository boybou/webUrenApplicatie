import { Component, Injectable } from '@angular/core';
import { Subject } from 'rxjs/Subject'


@Injectable()
export class Authorization {
    public ding$ = new Subject<boolean>();
    logedIn : boolean= false;
  
  isLogedIn(){
      this.logedIn = true;
  }

  getLogedin(){
      return this.logedIn;
  }
}
