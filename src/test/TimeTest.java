package test;

class Times extends Time {

}

class Time {
  private int hour;
  private int minute;
  private int second;

  public void setHour(int hour) {
    if(isValidHour(hour)) {
      return;
    }
    this.hour = hour;
  }

  private boolean isValidHour(int hour) {
    return hour < 0 || hour > 23;
  }

  public int getHour() {
    return hour;
  }
}

public class TimeTest {
  public static void main(String[] args) {
    Time t = new Time();
    Times tt = new Times();
    t.setHour(21);
    System.out.println(t.getHour());
    t.setHour(100);
    System.out.println(t.getHour());
    if (t instanceof Times) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }
  }
}
