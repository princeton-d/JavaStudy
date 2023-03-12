package test;

public class EqualsTest {
  int value;

  public EqualsTest(int value) {
    this.value = value;
  }

  public static void main(String[] args) {
    EqualsTest test1 = new EqualsTest(10);
    EqualsTest test2 = new EqualsTest(10);

    System.out.println(test1.equals(test2));

    test2 = test1;

    System.out.println(test1.equals(test2));
  }
}
