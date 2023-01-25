package chap_02;

public class _Quiz_02 {
  public static void main(String[] args) {
//    퀴즈2
//    어린이 키에 따른 놀이 기구 탑승 가능 여부를 확인하는 프로그램을 작성하시오.

//    조건
//    키가 120 cm 이상인 경우에만 탑승 가능
//    삼항 연산자 이용

//    실행 결과
//    키가 115cm 이므로 탑승 불가능합니다.
//    키가 121cm 이므로 탑승 가능합니다.

    int x = 115;
    int y = 121;

    String resultX = x >= 120 ? "키가 " + x + "cm 이므로 탑승 가능합니다" : "키가 " + x + "cm 이므로 탑승 불가능합니다";
    String resultY = y >= 120 ? "키가 " + y + "cm 이므로 탑승 가능합니다" : "키가 " + y + "cm 이므로 탑승 불가능합니다";

    System.out.println(resultX);
    System.out.println(resultY);

    resultX = x >= 120 ? "가능합니다" : "불가능합니다";
    resultY = x >= 120 ? "가능합니다" : "불가능합니다";

    System.out.println("키가 " + x + "cm 이므로 탑승 " + resultX);
    System.out.println("키가 " + y + "cm 이므로 탑승 " + resultY);
  }
}
