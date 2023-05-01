public class Test {
    int num1, num2;

    static int add(int num1, int num2) { // 메서드 반환타입 앞에 static 이 붙었기 때문에 static 메서드가 됩니다.
        System.out.println();
        System.out.println("매개변수로 입력 받은 num1, num2 확인");
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);

        System.out.println("num1 + num2 = " + (num1 + num2));
        return num1 + num2;
    }
}
