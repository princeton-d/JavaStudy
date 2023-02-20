package test;

public class Lambda {
  int max(int a, int b) {
    return a > b ? a : b;
  }

  void printVar(String name, int i) {
    System.out.println(name + "=" + i);
  }

  int square(int x) {
    return x * x;
  }

  int roll() {
    return (int) (Math.random() * 6);
  }

  public static void main(String[] args) {
  }
}
