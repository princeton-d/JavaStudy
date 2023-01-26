package chap_03;

public class _01_String1 {
  public static void main(String[] args) {
    String s = "I like Java and Python and C.";
    System.out.println(s);

//    문자열의 길이
    System.out.println(s.length()); // 29

//    대소문자 변환
    System.out.println(s.toUpperCase()); // I LIKE JAVA AND PYTHON AND C.
    System.out.println(s.toLowerCase()); // i like java and python and c.

//    포함 관계
    System.out.println(s.contains("Java")); // 포함된다면 true -> true
    System.out.println(s.contains("C#")); // 포함되지 않는다면 false -> false
    System.out.println(s.indexOf("Java")); // 위치 정보 -> 7
    System.out.println(s.indexOf("C#")); // 위치 정보 -> 포함되지 않는다면 -1
    System.out.println(s.indexOf("and")); // 첫번째 일치하는 위치 정보
    System.out.println(s.lastIndexOf("and")); // 마지막 일치하는 위치 정보
    System.out.println(s.startsWith("I like")); // 이 문자열로 시작하면 true(아니면 false) -> true
    System.out.println(s.endsWith("C.")); // 이 문자열로 끝나면 true(아니면 false) -> true
  }
}
