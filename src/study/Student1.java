package study;

public class Student1 {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;

    public Student1(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public String info() {
        int sumOfScore = this.kor + this.eng + this.math;
        float avgOfScore = Math.round(sumOfScore / 3f * 10f) / 10f;

        String info = this.name + "," + this.ban + "," + this.no + "," + this.kor + "," + this.eng + "," + this.math + "," + sumOfScore + "," + avgOfScore;

        return info;
    }
}
