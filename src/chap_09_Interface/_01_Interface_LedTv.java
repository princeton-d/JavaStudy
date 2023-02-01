package chap_09_Interface;

public class _01_Interface_LedTv implements _01_Interface {
  public int MIN_VOLUME = 0;
  public int MAX_VOLUME = 100;

  public void turnOn() {
    System.out.println("켜다");
  };

  public void turnOff() {
    System.out.println("끄다");
  };

  public void changeVolume(int volume) {
    System.out.println("볼륨을 조정하다");
  };

  public void changeChannel(int channel) {
    System.out.println("채널을 바꾸다");
  };

  public static void main(String[] args) {
    _01_Interface tv = new _01_Interface_LedTv();
    tv.turnOn();
  }
}
