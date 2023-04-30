package study;

public class Student2 {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;

    public int getTotal() {
        int total = this.kor + this.eng + this.math;

        return total;
    }

    public float getAverage() {
        float avg = Math.round((this.kor +this.eng + this.math)/3f * 10f) / 10f;

        return avg;
    }
}
