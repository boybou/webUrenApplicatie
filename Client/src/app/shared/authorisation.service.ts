import {Injectable} from "@angular/core";
import {HttpHeaders} from "@angular/common/http";


export class AuthorisationService{
  public static header:HttpHeaders = new HttpHeaders();
  public static employeeNumber:number;
  constructor(){

  }
  public setHeader(emailAddress: string, password: string){
    let authString = 'Basic ' + btoa(emailAddress+':'+ password);
    AuthorisationService.header = AuthorisationService.header.set('Authorization',authString);

  }

}
