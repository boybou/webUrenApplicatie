export class Employee{
  constructor(private _employee_Firstname: string,
              private  _employee_Lastname: string,
              private  _employee_Type_Name: string,
              private _employee_Employee_Number: number,
              private _employee_Role_Name: string,
              private _employee_Active: boolean){}

  get employee_Firstname(): string {
    return this._employee_Firstname;
  }

  set employee_Firstname(value: string) {
    this._employee_Firstname = value;
  }

  get employee_Lastname(): string {
    return this._employee_Lastname;
  }

  set employee_Lastname(value: string) {
    this._employee_Lastname = value;
  }

  get employee_Type_Name(): string {
    return this._employee_Type_Name;
  }

  set employee_Type_Name(value: string) {
    this._employee_Type_Name = value;
  }

  get employee_Employee_Number(): number {
    return this._employee_Employee_Number;
  }

  set employee_Employee_Number(value: number) {
    this._employee_Employee_Number = value;
  }

  get employee_Role_Name(): string {
    return this._employee_Role_Name;
  }

  set employee_Role_Name(value: string) {
    this._employee_Role_Name = value;
  }

  get employee_Active(): boolean {
    return this._employee_Active;
  }

  set employee_Active(value: boolean) {
    this._employee_Active = value;
  }
}
