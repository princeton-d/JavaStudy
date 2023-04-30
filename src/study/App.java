package study;

public class App {

    public static void main(String[] args) {
        Student1 s1 = new Student1("홍길동", 1, 1, 100, 60, 76);

        String str = s1.info();
        System.out.println(str);

        Student2 s2 = new Student2();
        s2.name = "홍길동";
        s2.ban = 1;
        s2.no = 1;
        s2.kor = 100;
        s2.eng = 60;
        s2.math = 76;

        System.out.println("이름:" + s2.name);
        System.out.println("총점:" + s2.getTotal());
        System.out.println("평균:" + s2.getAverage());
    }
}