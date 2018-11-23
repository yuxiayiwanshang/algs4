public class Date implements Comparable<Date>{
  private static final int[] DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
  private final int day;
  private final int month;
  private final int year;
  
  public Date(int day,int month,int year){
    this.day = day;
    this.month= month;
    this.year = year;
  }
  
  public Date(String date){
    String[] fields = date.split("/");
    if (fields.length != 3) {
        throw new IllegalArgumentException("Invalid date");
    }
    day = Integer.parseInt(fields[2]);
    month = Integer.parseInt(fields[1]);
    year= Integer.parseInt(fields[0]);
  }
  
  public int Date(){
    return day;
  }
  
  public int Month(){
    return month;
  }
  
  public int Year(){
    return year;
  }
  
  private static boolean isLeapYear(int y) {
    if (y % 400 == 0) return true;
    if (y % 100 == 0) return false;
    return y % 4 == 0;
  }
  
  private static boolean isValid(int d, int m, int y) {
    if (m < 1 || m > 12)      return false;
    if (d < 1 || d > DAYS[m]) return false;
    if (m == 2 && d == 29 && !isLeapYear(y)) return false;
    return true;
  }
  
  public Date next(){
    if(isValid(day+1,month,year)) return new Date(day+1,month,year);
    else if(isValid(1,month+1,year)) return new Date(1,month+1,year);
    else return new Date(1,1,year);
  }
  
  public boolean isAfter(Date that) {
    return compareTo(that) > 0;
  }

  
  public boolean isBefore(Date that) {
    return compareTo(that) < 0;
  }
  
  @Override
  public int compareTo(Date that) {
    if (this.year  < that.year)  return -1;
    if (this.year  > that.year)  return +1;
    if (this.month < that.month) return -1;
    if (this.month > that.month) return +1;
    if (this.day   < that.day)   return -1;
    if (this.day   > that.day)   return +1;
    return 0;
  }
  
  public boolean eqauls(Object other){
    if(other == null ) return false;
    else if(this == other) return true;
    else if(this.getClass() != other.getClass()) return false;
    Date others = (Date) other;
    if (this.day == others.day && this.month == others.month && this.year == others.year) return true;
    else return false;
  }
  
  public int hasCode(){
    int hash = 17;
    hash = 31*hash + day;
    hash = 31*hash + month;
    return 31*hash + year;
  }
  
  public String toString() {
    return month + "/" + day + "/" + year;
  }
  
  
  public static void main(String[] args) {
        Date today = new Date(25, 2, 2004);
        System.out.println(today);
        for (int i = 0; i < 10; i++) {
            today = today.next();
            System.out.println(today);
        }

        System.out.println(today.isAfter(today.next()));
        System.out.println(today.isAfter(today));
        System.out.println(today.next().isAfter(today));


        Date birthday = new Date(16,10, 1971);
        System.out.println(birthday);
        for (int i = 0; i < 10; i++) {
            birthday = birthday.next();
            System.out.println(birthday);
        }
    }
  
  
}
