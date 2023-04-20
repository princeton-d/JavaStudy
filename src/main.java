public class main {
    public static void main(String[] args) {
        Calculator c1 = new Calculator(); // 인스턴스 객체
    
        c1.setOprands(10, 20);
        c1.sum();
        c1.avg();
    
        Calculator c2 = new Calculator();
        c2.setOprands(30, 50);
        c2.sum();
        c2.avg();
    }
}