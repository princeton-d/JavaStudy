import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args) {

        int[] numbers = {0, 31, 24, 28, 39, 37};
        int firstNumber = 39;
        int secondNumber = 37;

        for (int i = 0; i < numbers.length; i++) {
            //비교하려는 숫자가 가장 큰 숫자일때
            if (numbers[i] > firstNumber) {
                secondNumber = firstNumber;
                firstNumber = numbers[i];
            }
            //비교하려는 숫자가 2번째로 큰 숫자일때
            if (secondNumber < numbers[i] && numbers[i] < firstNumber){
                secondNumber = numbers[i];
            }
        }

        System.out.println(firstNumber * secondNumber);;
    }
}