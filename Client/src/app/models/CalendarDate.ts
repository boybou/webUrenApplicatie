export class CalendarDate{
  public dayNumber:number;
  public dayName: string;
  constructor(
    public year:number,
    public month:number,
    public day:number
  ){
    this.getDayInfo()
  }
  getDayInfo(){
    let date:Date = new Date(this.year,this.month-1,this.day)
    this.dayNumber = date.getDay();
    this.dayName = this.getDayName();
  }
  private getDayName() {
    switch (this.dayNumber){
      case 0: return "Zondag";
      case 1: return "Maandag";
      case 2: return "Dinsdag";
      case 3: return "Woensdag";
      case 4: return "Donderdag";
      case 5: return "Vrijdag";
      case 6: return "Zaterdag";
    }
  }
  addDay(){
      if(this.day<this.getMonthLenght(this.month,this.year)){
        this.day++;
      }
      else if (this.day==this.getMonthLenght(this.month,this.year)){
        this.day = 1;
        if (this.month == 12){
          this.month = 1;
          this.year++;
        }
        else {
          this.month++
        }
      }
      this.getDayInfo()
  }
  subtractDay(){
    if(this.day==1){
      if(this.month == 1){
        this.month = 12;
        this.year--;
        this.day = this.getMonthLenght(this.month,this.year)
      }
      else{
      this.month--;
      this.day = this.getMonthLenght(this.month,this.year)
      }
    }
    else {
      this.day--
    }
    this.getDayInfo()
  }

  getMonthLenght(month:number,year:number){
      if(month ==2 && year % 4 == 0){
        return 29
      }
      else if (month == 2){
        return 28
      }
      else if (month == 1){
        return 31
      }
      else if (month == 3){
        return 31
      }
      else if (month == 4){
        return 30
      }
      else if (month == 5){
        return 31
      }
      else if (month == 6){
        return 30
      }
      else if (month == 7){
        return 31
      }
      else if (month == 8){
        return 31
      }
      else if (month == 9){
        return 30
      }
      else if (month == 10){
        return 31
      }
      else if (month == 11){
        return 30
      }
      else if (month == 12){
        return 31
      }


  }
  public toDateString():string{
    return this.year + "-" + this.month + "-" + this.day;
  }


}
