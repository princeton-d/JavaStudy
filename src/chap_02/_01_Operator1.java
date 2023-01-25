package chap_02;

public class _01_Operator1 {
  public static void main(String[] args) {
//    산술 연산자

//    일반 연산
    System.out.println(4 + 2); // 6
    System.out.println(4 - 2); // 2
    System.out.println(4 * 2); // 8
    System.out.println(4 / 2); // 2
    System.out.println(5 / 2); // 2 -> 정수 연산이기 때문에 소수점이 버려점
    System.out.println(2 / 4); // 0 -> 정수 연산!
    System.out.println(4 % 2); // 0 나머지 연산 4를 2로 나눈 나머지 값
    System.out.println(5 % 2); // 1

//    우선 순위 연산
    System.out.println(2 + 2 * 2); // 6 -> 일반 수학을 계산하는것처럼 곱하기를 먼저 연산함
    System.out.println((2 + 2) * 2); // 8 -> 괄호 안에 있는 연산을 우선적으로 계산해줌
    System.out.println(2 + (2 * 2)); // 6

//    변수를 이용한 연산
    int a = 20;
    int b = 10;
    int c;

    c = a + b;
    System.out.println(c); // 30

    c = a - b;
    System.out.println(c); // 10

    c = a * b;
    System.out.println(c); // 200

    c = a / b;
    System.out.println(c); // 2

    c = a % b;
    System.out.println(c); // 0

//    증감 연산 ++, --
    int val;
    val = 10;
    System.out.println(val); // 10

    val++; // ++ -> 1을 더해줌
    System.out.println(val); // 11

    System.out.println(++val); // 12

    System.out.println(val++); // 12 -> 변수 뒤에 넣어준 ++연산자는 해당 줄의 코드를 다 실행한 후에 더해주기 때문에 12가 나온다. 하지만 val 의 값은 13이 맞다.
    System.out.println(val); // 13 -> 위에 val++ 에서 연산을 해줬기 때문에 실제 수는 13이다.

    val = 10;
    System.out.println(val); // 10
    System.out.println(--val); // 9
    System.out.println(val--); // 9 -> -- 연산자도 동일하게 작동한다.
    System.out.println(val); // 8
  }
}
