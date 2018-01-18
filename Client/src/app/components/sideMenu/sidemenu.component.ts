import { Component } from '@angular/core';
import {AuthorisationService} from "../../shared/authorisation.service";

@Component({
    selector: 'side-menu',
    templateUrl: './sidemenu.component.html',
    styleUrls: ['./sidemenu.component.css']
})

export class SideMenu{


    private isAdmin(){
      if(AuthorisationService.role == "administrator"){
        return true
      }
      return false;
    }
    openSlideMenu(){
        document.getElementById('side-menu').style.width = '250px';
        document.getElementById('main').style.marginLeft = '250px';
    }

    closeSlideMenu(){
        document.getElementById('side-menu').style.width = '0';
        document.getElementById('main').style.marginLeft = '0';
      }

}
