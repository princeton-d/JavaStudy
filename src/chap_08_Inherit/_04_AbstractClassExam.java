package chap_08_Inherit;

public class _04_AbstractClassExam extends _04_AbstractClass {
  public void sing() {
    System.out.println("꽥꽥!");
  }

  public static void main(String[] args) {
    _04_AbstractClassExam duck = new _04_AbstractClassExam();
    duck.sing();
    duck.fly();
  }
}
