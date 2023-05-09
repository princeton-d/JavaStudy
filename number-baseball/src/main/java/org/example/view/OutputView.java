package org.example.view;

public class OutputView {
    private final String CORRECT_ANSWER = "3스트라이크";

    public void printStartMessage(boolean isRestart) {
        if (!isRestart) {
            System.out.println("숫자 야구 게임을 시작합니다.");
        }
    }

    public void printEnterAnswerGuid() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    public void printResultMessage(String resultMessage) {
        System.out.println(resultMessage);
    }

    public boolean isCorrectAnswer(String resultMessage) {
        if (resultMessage.contains(CORRECT_ANSWER)) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            return true;
        }

        return false;
    }
}
