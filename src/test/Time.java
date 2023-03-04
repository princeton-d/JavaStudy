package test;

public class Time {
  private int hour;
  private int minute;
  private int second;
  private final int MAX_HOUR = 24;
  private final int MAX_MINUTE_AND_SECOND = 59;
  private final int MIN_TIME = 0;

  public int getHour() {
    return hour;
  }

  public void setHour(int hour) {
    if (hour >= MIN_TIME && hour <= MAX_HOUR) {
      this.hour = hour;
    } else {
      this.hour = 0;
      System.out.println("0 ~ 24시로 설정하지 않은 경우 0시로 설정됩니다.");
    }
  }

  public int getMinute() {
    return minute;
  }

  public void setMinute(int minute) {
    if (minute >= MIN_TIME && minute <= MAX_MINUTE_AND_SECOND) {
      this.minute = minute;
    } else {
      this.minute = 0;
      System.out.println("0 ~ 59분으로 설정하지 않은 경우 0분으로 설정됩니다.");
    }
  }

  public int getSecond() {
    return second;
  }

  public void setSecond(int second) {
    if (second >= MIN_TIME && second <= MAX_MINUTE_AND_SECOND) {
      this.second = second;
    } else {
      this.second = 0;
      System.out.println("0 ~ 59초로 설정하지 않은 경우 0초로 설정됩니다.");
    }
  }

  public String printTime() {
    return this.getHour() + "시 " + this.getMinute() + "분 " + this.getSecond() + "초";
  }
}
