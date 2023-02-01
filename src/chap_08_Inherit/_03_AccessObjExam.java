package chap_08_Inherit;

public class _03_AccessObjExam {
  public static void main(String[] args) {
    _03_AccessObj obj = new _03_AccessObj();
    System.out.println(obj.p);
    System.out.println(obj.p2);
    System.out.println(obj.k);
//    System.out.println(obj.i); private 은 자기 자신만 접근할 수 있기 때문에 사용 불가
  }
}
