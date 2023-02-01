package chap_08_Inherit;

public class _01_Inherit extends _01_InheritTarget{
  public void ppangppang() {
    System.out.println("ppangppang~!");
  }
  public static void main(String[] args) {
    _01_Inherit bus = new _01_Inherit();
    bus.run();
    bus.ppangppang();
  }
}
