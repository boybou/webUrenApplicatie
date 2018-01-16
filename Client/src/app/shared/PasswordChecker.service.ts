import { Injectable } from '@angular/core';

@Injectable()
export class PasswordcheckerService {
  constructor(public noMatch:string = "Passwords do not match",
  public notLongEnough:string = "Password is not long enough",
  public noCaptial:string = "Password does not contain an captial letter",
  public noNumber:string = "Password does not contain an number",
  public succesfull:string = "User toegevoegd") {
  }

  public checkPassword(password: string, checkPassword: string) {
    console.log('In check password')
    console.log((password.length > 6))
    console.log((this.passwordHasCaptial(password)))
    console.log((this.passwordHasNumber(password)))
    if(password != checkPassword){
      return this.noMatch;
    }
    if (!(password.length > 6)) {
      return this.notLongEnough;
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
    console.log('In has captal password')
    for (i; i < password.length; i++) {
      console.log(password[i])
      if (password[i] == password[i].toUpperCase()) {
        console.log(password[i] + " is dit hoofdletter?")
        return true;
      }
    }
    return false;

  }

  private passwordHasNumber(password: string) {
    let i: number = 0;
    console.log('In has number password')
    for (i; i < password.length; i++) {
      if (password[i] >= '0' && password[i] <= '9') {
        console.log(password[i] + " is dit numer?")
        return true;
      }
    }
    return false;
  }

}
