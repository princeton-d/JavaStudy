package chap_01;

public class _05_Constants {
//  상수는 절대 변하지 않는 값에 할당해준다.
  public static void main(String[] args) {
    final String KR_COUNTRY_CODE = "+82";
//  KR_COUNTRY_CODE = "+83"; // final(상수)로 선언했기 때문에 오류 메시지를 출력한다.

    final double PI = 3.141592; // 원주율은 변하지 않으니 상수로 선언할 수 있다.
    final String DATE_OF_BIRTH = "1995-02-20"; // 생일도 변하지 않는 값이니 상수로 설정
  }
}
