export class Hour{
  constructor(private _hour_approved:string,
  private _hour_subproject_number:number,
  private _hour_employee_number:number,
  private _startTime:string,
  private _endTime:string,
  private _hour_amount_of_hours:string,
  private _hour_comments:string,
  private _hour_date:string,
  private _id:number){

  }

  get hour_approved(): string {
    return this._hour_approved;
  }

  set hour_approved(value: string) {
    this._hour_approved = value;
  }

  get hour_subproject_number(): number {
    return this._hour_subproject_number;
  }

  set hour_subproject_number(value: number) {
    this._hour_subproject_number = value;
  }

  get hour_employee_number(): number {
    return this._hour_employee_number;
  }

  set hour_employee_number(value: number) {
    this._hour_employee_number = value;
  }

  get startTime(): string {
    return this._startTime;
  }

  set startTime(value: string) {
    this._startTime = value;
  }

  get endTime(): string {
    return this._endTime;
  }

  set endTime(value: string) {
    this._endTime = value;
  }

  get hour_amount_of_hours(): string {
    return this._hour_amount_of_hours;
  }

  set hour_amount_of_hours(value: string) {
    this._hour_amount_of_hours = value;
  }

  get hour_comments(): string {
    return this._hour_comments;
  }

  set hour_comments(value: string) {
    this._hour_comments = value;
  }

  get hour_date(): string {
    return this._hour_date;
  }

  set hour_date(value: string) {
    this._hour_date = value;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }
}
