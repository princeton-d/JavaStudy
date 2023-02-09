package test;

public class Inherit {
  int x;
  int y;

  public Inherit(int x, int y) {
    this.x = x;
    this.y = y;
  }
  public int plus(int x, int y) {
    return x + y;
  }

  public static void main(String[] args) {
    class Pl extends Inherit {
      public Pl(int x, int y) {
        super(x, y);
      }

      void asd() {

      }
    }

    Pl test = new Pl(1, 2);

    System.out.println(test.plus(test.x, test.y));
  }
}
