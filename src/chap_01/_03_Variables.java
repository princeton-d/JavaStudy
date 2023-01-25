package chap_01;

public class _03_Variables {
  public static void main(String[] args) {
    String name = "WebSteak"; // String -> 문자열
    int hour = 15; // int -> 정수형 변수

    System.out.println(name + "님, 배송이 시작됩니다. " + hour + "시 방문 예정입니다.");
    System.out.println(name + "님, 배송이 완료되었습니다.");

    double score = 90.5; // double -> 실수, 아주 정밀한 데이터를 가질 때 사용함
    char grade = 'A'; // char -> 하나의 캐릭터, 하나의 문자만 할당항 때는 char 과 ''(작은따옴표)를 사용한다.
    name = "김동현"; // 변수는 재할당이 가능하다.

    System.out.println(name + "님의 평균 점수는 " + score + "점입니다.");
    System.out.println("학점은 " + grade + "입니다.");

    boolean pass = true; // -> boolean -> 불리언 값(true, false)

    System.out.println("이번 시험에 합격했을까요? " + pass);

    double d = 3.14123456789;
    float f = 3.14123456789F; // float 도 실수를 할당할 수 있지만 실수 뒤에 F 나 f 를 같이 붙여줘야한다.

    System.out.println(d);
    System.out.println(f);

//    int i = 1000000000000; // int 가 포함할 수 있는 수는 -21억 ~ 21억 까지이다. 1000000000000(0 12개)은 그 값을 초과하기 때문에 수정해줘야한다.
    long l = 1000000000000L; // long 자료형과 숫자 뒤에 L 또는 l 을 집어넣으면 큰 값을 담을 수 있다.
    l = 1_000_000_000_000L; // 숫자를 좀 더 편하게 읽을 수 있도록 _ 로 표시를 해줘도 무방하다.

    System.out.println(l);
  }
}
