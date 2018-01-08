import {BrowserModule} from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes} from '@angular/router';

import { AppComponent } from './app.component';
import {SandboxComponent} from './components/sandbox/sandbox.component';
import {Hour} from './components/hourcomponent/hour.component';
import {Login} from './components/loginComponent/login.component';
import {Header} from './components/headerComponent/header.component';
import {SideMenu} from './components/sideMenu/sidemenu.component';
import { Authorization } from './components/sharedComponent/authorization.serve';
import { HomeComponent } from './components/home/home.component';
import { AccountmanagementComponent } from './components/accountmanagement/accountmanagement.component';
import { StatistictsComponent } from './components/statisticts/statisticts.component';
import { HourapprovalComponent } from './components/hourapproval/hourapproval.component';
import { ExportComponent } from './components/export/export.component';
import { HouroveriewComponent } from './components/houroveriew/houroveriew.component';
import { UserinfoComponent } from './components/userinfo/userinfo.component';
import {HttpClientModule, HttpHeaders} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {AuthorisationService} from "./shared/authorisation.service";
import {ApiService} from "./shared/api.service";
import {CookieService} from "ngx-cookie-service";
import { HomeHeaderComponent } from './components/home-header/home-header.component';
import { PendingHourComponent } from './components/pending-hour/pending-hour.component';


const appRoutes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'login', component: Login},
  {path: 'hourInsert', component: Hour},
  {path: 'accountManagement', component: AccountmanagementComponent},
  {path: 'statistics', component: StatistictsComponent},
  {path: 'hourApproval', component: HourapprovalComponent},
  {path: 'export', component: ExportComponent},
  {path: 'hourOverview', component: HouroveriewComponent},
  {path: 'userInfo', component: UserinfoComponent}

];


@NgModule({
  declarations: [
    AppComponent,
    SandboxComponent,
    Hour,
    Login,
    Header,
    SideMenu,
    HomeComponent,
    AccountmanagementComponent,
    StatistictsComponent,
    HourapprovalComponent,
    HouroveriewComponent,
    ExportComponent,
    UserinfoComponent,
    PendingHourComponent
    HomeHeaderComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    FormsModule
  ],
  providers: [Authorization,AuthorisationService,ApiService,CookieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
