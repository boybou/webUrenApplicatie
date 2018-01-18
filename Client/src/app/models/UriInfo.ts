export class UriInof{
  public static getHourByDate:string = "/api/hour/completeHourByDate";
  public static createUser:string = "/api/users";
  public static getEmployee(id:number):string{
    return '/api/employee/'+id;
  }
}
