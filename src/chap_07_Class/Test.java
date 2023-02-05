package chap_07_Class;

public class Test {
  static final int WIDTH = 100;
  static final int HEIGHT = 200;
  public int num;
  public String kind;

  public Test(int num, String kind) {
    this.num = num;
    this.kind = kind;
  }

  public static void main(String[] args) {
    Test card = new Test(6, "hart");
  }
}
