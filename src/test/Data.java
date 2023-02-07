package test;

public class Data {
  public int x;
  public static void main(String[] args) {
    Data d = new Data();
    d.x = 10;
    System.out.println("main() : x = " + d.x);
  }
}
