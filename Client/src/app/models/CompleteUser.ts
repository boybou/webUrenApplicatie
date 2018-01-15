export class CompleteUser {
  constructor(public employee_Firstname?: string,
              public employee_Lastname?: string,
              public employee_Type_Name?: string,
              public employee_Role_Name?: string,
              public employee_Active?: boolean,
              public password?: string,
              public email?: string
             ) {

  }
}
