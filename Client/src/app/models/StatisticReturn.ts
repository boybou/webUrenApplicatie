export class StatisticReturn
{
  constructor(
    private _employee?: string,
    private _project?: string,
    private _subproject?: string,
    private _hours?: number,
    private _minutes?: number) {
  }

  public get employee(): string {
    return this._employee;
  }

  public set employee(value: string) {
    this._employee = value;
  }

  public get project(): string {
    return this._project;
  }

  public set project(value: string) {
    this._project = value;
  }

  public get subproject(): string {
    return this._subproject;
  }

  public set subproject(value: string) {
    this._subproject = value;
  }

  public get hours(): number {
    return this._hours;
  }

  public set hours(value: number) {
    this._hours = value;
  }

  public get minutes(): number {
    return this._minutes;
  }

  public set minutes(value: number) {
    this._minutes = value;
  }
}

