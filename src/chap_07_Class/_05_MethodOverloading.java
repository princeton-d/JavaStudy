package chap_07_Class;

//  같은 매서드 이름을 사용해도 매개변수의 갯수와 타입을 다르게 한다면 같은 이름의 매서드를 사용할 수 있다.
public class _05_MethodOverloading {
  public int plus(int x, int y) {
    return x + y;
  }

  public int plus(int x, int y, int z) {
    return x + y + z;
  }

  public static String plus(String x, String y) {
    return x + y;
  }


  public static void main(String[] args) {
    _05_MethodOverloading m = new _05_MethodOverloading();

    System.out.println(m.plus(3,4));
    System.out.println(_05_MethodOverloading.plus("hello", " world"));
  }
}
