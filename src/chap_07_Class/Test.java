package chap_07_Class;

public class Test {
  static final int WIDTH = 100;
  static final int HEIGHT = 200;

  public final String HART = "hart";
  public final String DIAMOND = "diamond";
  public final String CLOVER = "clover";
  public final String SPADE = "spade";

  public int num;
  public Kind kind;

  public Test(int num, Kind kind) {
    this.num = num;
    this.kind = kind;
  }

  public static void main(String[] args) {
    Test card = new Test(6, Kind.HART);
  }
}

enum Kind {
  HART, SPADE, DIAMOND, CLOVER;
}