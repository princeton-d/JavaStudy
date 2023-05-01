public class Test2 {

    public static void main(String[] args) {
        Test methodTest = new Test();
        methodTest.num1 = 10;
        methodTest.num2 = 20;

        Test.add(methodTest.num1, methodTest.num2);
    }

}