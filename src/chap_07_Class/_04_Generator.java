package chap_07_Class;

public class _04_Generator {
  String name;
  int number;

  public _04_Generator(String name, int number) {
    this.name = name;
    this.number = number;
  }

  public static void main(String[] args) {
    _04_Generator c1 = new _04_Generator("소방차", 1234);
    _04_Generator c2 = new _04_Generator("경찰차", 1541);

    System.out.println(c1.name);
  }
}
