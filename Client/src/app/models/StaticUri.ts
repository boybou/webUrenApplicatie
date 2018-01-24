export class StaticUri{
  public static insertEmployee:string = "/api/employee";
  public static retrieveEmployee(id:number){
    return  "/api/employee/" + id;
  }
  public static getHour(id:number){
    return "/api/hour/"+id;
  }
  public static retrievePersonalHours:string = "/api/hour/me";
  public static insertHour:string = "/api/hour";
  public static getPendingHours:string = "/api/hour/pendinghours";
  public static approveHour(id:number){
    return "/api/hour/"+id;
  }
  public static disapproveHour(id:number){
    return "/api/hour/"+id;
  }
  public static sendStatistics:string = "/api/statistics";
  public static updateLoginData:string = "/api/user";
  public static insertLoginData:string = "/api/user";
  public static getLoginDataByEmail(email:string){
    return "/api/user/"+email;
  }
  public static getSelf:string = "/api/user/me";

  public static getHourByDate(date:string){
    return "/api/hour/me/"+date;
  }
  public static createUser:string = "/api/user";
  public static getEmployee(id:number):string{
    return '/api/employee/'+id;
  }
}
