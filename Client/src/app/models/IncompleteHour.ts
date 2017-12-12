
export class IncompleteHour
{
  constructor(
    public hour_client?: string,
    public hour_project_name?: string,
    public hour_subproject_name?: string,
    public hour_employee_number?: number,
    public startTime?: string,
    public endTime?: string,
    public hour_comments?: string,
    public hour_date?: string
  )
  {

  }

}
