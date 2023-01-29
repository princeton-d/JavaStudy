package chap_07_Class;

public class _01_Class1 {
  public static void main(String[] args) {
//    메모리에 만들어진 클레스 객체를 인스턴스라고 한다.
    _01_Class1 car1 = new _01_Class1();
    _01_Class1 car2 = new _01_Class1();

//    참조형 타입 String
    String str1 = "hello world"; // String 클레스는 new 를 이용하지 않고도 생성을 할 수 있다.
    String str2 = "hello world"; // new 연산자를 사용하지 않고 생성한 String 클래스는 값이 같다면 같은 인스턴스를 참조한다.

    String str3 = new String("hello world"); // String 클래스
    String str4 = new String("hello world"); // new 를 사용해서 만든 String 클래스는 내용이 같더라도 새로운 영역에 따로 값을 만든다.

    System.out.println(str1 == str2); // 같은 영역을 가르키기 때문에 true 를 반환함.
    System.out.println(str1 == str3); // 같은 값을 가지지만 new 를 통해 생성했기 때문에 false 를 반환함
  }
}
