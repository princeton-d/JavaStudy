package chap_01;

public class _04_Comment {
  public static void main(String[] args) {
//    cmd + d -> 현재 줄에 있는 코드를 바로 아래줄에 복사해서 작성해줌
    System.out.println("(10분전) 잠시 후 결혼식 시작 예정이오니 착석 부탁드립니다.");
    System.out.println("(5분전) 잠시 후 결혼식 시작 예정이오니 착석 부탁드립니다.");
    System.out.println("지금부터 결혼식을 시작하겠습니다.");
//    // 이렇게 슬래쉬(/)를 두 개 붙여주면 같은줄에 작성하는 코드는 주석처리 되고 코드 실행시에는 무시된다.

    int size = 120;
    size = size + 10; // 어린이는 발이 빨리 자라기 때문에 사이즈 10만큼 더 큰 신발을 구매
//    이런식으로 코드 뒤에 주석을 작성해주면 왜 그렇게 코드를 짜게 되었는지 흐름을 알기 용이하다.
    System.out.println("신발 사이즈" + size + "으로 보여주세요");

//    한줄 주석: cmd + /
//    여러줄 주석: cmd + shift + /
  }
}
