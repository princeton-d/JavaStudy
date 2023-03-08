package test;

public class TimeTest {
  public static void main(String[] args) {
    Time time = new Time();
    time.setHour(21);
    time.setMinute(30);
    time.setSecond(58);

    System.out.println(time.printTime());
  }
}
