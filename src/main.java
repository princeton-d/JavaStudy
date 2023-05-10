import java.util.List;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class main {
    static int[] answerArr = new int[3];
    static Scanner scanner = new Scanner(System.in);
    static int firstNum = 0;
    static int secondNum = 0;
    static int finalNum = 0;

    static int userRestartNum = 1;

    public static void main(String[] args) {
        printStartMent();
        while (userRestartNum == 1) {
            answerNumber();
            userNumberInput();
            judgeMent();
        }
    }

    private static void printStartMent() {
        System.out.print("숫자 야구 게임을 시작합니다.\n숫자를 입력해주세요 : ");
    }

    private static void userNumberInput() {
        int userNumber = scanner.nextInt();
        String strUserNum = Integer.toString(userNumber);
        String[] userArr = strUserNum.split("");
        firstNum = Integer.parseInt(userArr[0]);
        secondNum = Integer.parseInt(userArr[1]);
        finalNum = Integer.parseInt(userArr[2]);
    }

    private static int[] answerNumber() {
        while (
                answerArr[0] == answerArr[1]
                        || answerArr[1] == answerArr[2]
                        || answerArr[2] == answerArr[0]
        ) {
            answerArr[0] = (int) (Math.random() * 9 + 1);
            answerArr[1] = (int) (Math.random() * 9 + 1);
            answerArr[2] = (int) (Math.random() * 9 + 1);
            System.out.println("first = " + answerArr[0]);
            System.out.println("second = " + answerArr[1]);
            System.out.println("final = " + answerArr[2]);
        }
        return answerArr;
    }

    //스캐너에서 입력받은 값과 answer 넘버에서 지정된 숫자를 비교하는 if문을 만든다
    //

    private static String judgeMent() {
        System.out.println("=======");
        // int[] -> List<Integer>
        // 숫자 3개 / 정답 3개 1, 2, 3 / 1, 2, 3
        // 스트라이크의 조건: 자리랑 숫자랑 다 맞는 경우
        // 볼의 조건: 숫자만 맞는 경우
        // 1. 스트라이크 전부 구한다. -> n스트라이크
        int strikeNum = 0;
        int ballNum = 0;
        if (firstNum == answerArr[0]) {
            strikeNum++;
        }
        if (secondNum == answerArr[1]) {
            strikeNum++;
        }
        if (finalNum == answerArr[2]) {
            strikeNum++;
        }

        List<Integer> answerArr2 = Arrays.asList(answerArr[0], answerArr[1], answerArr[2]);
        if (answerArr2.contains(firstNum)) {
            ballNum++;
        }
        if (answerArr2.contains(secondNum)) {
            ballNum++;
        }
        if (answerArr2.contains(finalNum)) {
            ballNum++;
        }
        ballNum = ballNum - strikeNum;

        if (strikeNum == 0 && ballNum != 0) {
            System.out.println(ballNum + "볼");
            return ballNum + "볼";
        }
        if (ballNum == 0 && strikeNum != 0) {
            System.out.println(strikeNum + "스트라이크");
            return strikeNum + "스트라이크";
        }
        if (strikeNum == 0 && ballNum == 0) {
            System.out.println("낫싱");
            return "낫싱";
        }
        if (strikeNum == 3) {
            System.out.println("?????");
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            userRestartNum = scanner.nextInt();
            if (userRestartNum == 1) {
                return "숫자야구게임을 시작합니다";
            }
        }
        System.out.println(ballNum + "볼" + " " + strikeNum + "스트라이크");
        return ballNum + "볼" + " " + strikeNum + "스트라이크";
    }
}