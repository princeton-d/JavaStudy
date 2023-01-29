package chap_07_Class;

public class _02_Method {
//      메서드 정의 방식
//    public 리턴타입 메소드명 (매개변수 등) { 구현 }

  //  1. 인자도, 리턴값도 없는 형태
  public void method1() {
    System.out.println("m1 이 실행됨...");
  }

  //  2. 인자가 들어가고 리턴값은 없는 형태
  public void method2(int x) {
    System.out.println(x + "를 이용한 m2 실행");
  }

  //  3. 인자는 없고 리턴값은 존재하는 형태
  public int method3() {
    System.out.println("m3 실행");
    return 10;
  }

  //  인자를 2개 이상 들어가고 리턴값은 없는 형태
  public void method4(int x, int y) {
    System.out.println(x + y + "method4 실행");
  }

  //  인자를 받아서 리턴값을 출력하는 형태
  public int method5(int x) {
    System.out.println(x + "이용한 m5 실행");
    return x * 2;
  }

  public static void main(String[] args) {
    _02_Method myclass = new _02_Method();
    myclass.method1();
    myclass.method2(10);
    int method3Return = myclass.method3();
    System.out.println(method3Return + " = method3 이 리턴한 값");
    myclass.method4(10, 20);
    int method5Return = myclass.method5(10);
    System.out.println(method5Return + " = method5 가 리턴한 값");
  }
}
