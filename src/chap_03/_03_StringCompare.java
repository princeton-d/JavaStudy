package chap_03;

public class _03_StringCompare {
  public static void main(String[] args) {
//    문자열 비교
    String s1 = "Java";
    String s2 = "Python";

    System.out.println(s1.equals(s2)); // 문자열 내용이 같으면 true, 다르면 false
    System.out.println(s1.equals("Java")); // true
    System.out.println(s2.equals("python")); // 대소문자 구분 정확하게 해야함 -> false
    System.out.println(s2.equalsIgnoreCase("python")); // 대소문자 구분 없이 문자열 내용이 같은지 여부 체크 -> true

//    문자열 비교 심화
    s1 = "1234";
    s2 = "1234";

    System.out.println(s1.equals(s2)); // true
    System.out.println(s1 == s2); // true

    s1 = new String("1234");
    s2 = new String("1234");

    System.out.println(s1.equals(s2)); // 참조가 같은지 비교하기 때문에 true 가 나온다 -> true
    System.out.println(s1 == s2); // s1 과 s2 는 서로 다른 1234 라는 값을 참조하기 때문에 등호를 이용할때는 다른 메모리 공간에 각각 존재하는 데이터이기 때문에 false 를 반환한다 -> false
  }
}
