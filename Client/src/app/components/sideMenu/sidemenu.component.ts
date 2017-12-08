import { Component } from '@angular/core';

@Component({
    selector: 'side-menu',
    templateUrl: './sidemenu.component.html',
    styleUrls: ['./sidemenu.component.css']
})

export class SideMenu{

    openSlideMenu(){
        document.getElementById('side-menu').style.width = '250px';
        document.getElementById('main').style.marginLeft = '250px';
    }

    closeSlideMenu(){
        document.getElementById('side-menu').style.width = '0';
        document.getElementById('main').style.marginLeft = '0';
      }

}