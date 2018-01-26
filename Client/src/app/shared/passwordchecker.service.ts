import { Injectable } from '@angular/core';

@Injectable()
export class PasswordcheckerService {
  public noMatch:string = "Wachtwoorden komen niet overeen";
  public noLength:string = "Wachtwoord is niet lang genoeg";
  public noCaptial:string = "Wachtwoord heeft geen hoofdletter";
  public noNumber:string = "Wachtwoord bevat geen nummer";
  public succesfull:string = "Action is succesfull";

  constructor() {
  }

  public checkPassword(password: string, checkPassword: string) {

    if(password != checkPassword){
      return this.noMatch
    }
    if (!(password.length > 6)) {
      return this.noLength
    }
    if (!(this.passwordHasCaptial(password))) {
      return this.noCaptial
    }
    if (!(this.passwordHasNumber(password))) {
      return this.noNumber
    }
    return this.succesfull

  }

  private passwordHasCaptial(password: string) {
    let i: number = 0;
    for (i; i < password.length; i++) {
      if (password[i] == password[i].toUpperCase()) {
        return true;
      }
    }
    return false;

  }

  private passwordHasNumber(password: string) {
    let i: number = 0;
    for (i; i < password.length; i++) {
      if (password[i] >= '0' && password[i] <= '9') {
        return true;
      }
    }
    return false;
  }

}
