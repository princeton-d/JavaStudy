package chap_03;

public class _02_String2 {
  public static void main(String[] args) {
    String s = "I like Java and Python and C.";

//    문자열 변환
    System.out.println(s.replace(" and", ",")); // 앞에 있는 파라미터를 뒤에 파라미터로 변경해줌 -> I like Java, Python, C.
    System.out.println(s.substring(7)); // 인덱스 기준 7 부터 시작 (이전 내용은 삭제, 원본을 수정함) -> Java and Python and C.
    System.out.println(s.substring(s.indexOf("Java"))); // indexOf 로 위치의 인덱스를 찾아서 거기부터 시작함 -> Java and Python and C.
    System.out.println(s.substring(s.indexOf("Java"), s.indexOf(".")));

//    공백 제거
    s = "           I love Java.           ";
    System.out.println(s);
    System.out.println(s.trim()); // 문자열 시작과 끝에 있는 공백을 제거

//    문자열 결합
    String s1 = "Java";
    String s2 = "Python";

    System.out.println(s1 + s2);
    System.out.println(s1 + "," + s2);
    System.out.println(s1.concat(",").concat(s2));
  }
}
