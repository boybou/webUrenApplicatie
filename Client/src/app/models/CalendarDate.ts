export class CalendarDate{
  public dayNumber:number;
  public dayName: string;
  constructor(
    public year:number,
    public month:number,
    public day:number
  ){
    let date:Date = new Date(year,month,day)
    this.dayNumber = date.getDay();
    this.dayName = this.getDayName();

  }

  private getDayName() {
    switch (this.dayNumber){
      case 0: return "Zondag"
      case 1: return "Maandag"
      case 2: return "Dinsdag"
      case 3: return "Woensdag"
      case 4: return "Donderdag"
      case 5: return "Vrijdag"
      case 6: return "Zaterdag"
    }
  }

}
