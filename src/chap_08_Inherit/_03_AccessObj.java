package chap_08_Inherit;

public class _03_AccessObj {
  public int p = 3;
  protected int p2 = 4; // 같은 패키지인 경우 접근 허용 다른 패키지라도 상속을 받은 경우 접근 허용
  private int i = 1; // 자기 자신만 접근 가능
  int k = 2; // default 접근 지정자: 아무것도 쓰지 않은 경우 자기 자신과 같은 패키지 내에서 접근 허용

//  접근 허용 범위 public > protected > default > private

}
