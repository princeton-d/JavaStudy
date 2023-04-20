public class Calculator {        // 클래스, 객체, 맴버=변수,메소드 (설계도)
    
    static int static_variable = 1;//클래스 변수
    int left, right;    //변수
    
    
    public void setOprands(int left, int right) {
        this.left = left;
        this.right = right;
    }
    
    public void sum() {
        System.out.println(this.left + this.right);
    }
    
    public void avg() {
        System.out.println((this.left + this.right) / 2);
    }
}