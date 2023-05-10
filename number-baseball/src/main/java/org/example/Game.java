package org.example;

import org.example.domain.AnswerNumbers;
import org.example.domain.ResultCheck;
import org.example.view.InputView;
import org.example.view.OutputView;

public class Game {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final ResultCheck resultCheck = new ResultCheck();
    private final int RESTART_NUMBER = 1;
    private final int END_NUMBER = 2;
    private boolean isCycle = true;

    public void startGame(boolean isRestart) {

        AnswerNumbers answerNumber = new AnswerNumbers();

        outputView.printStartMessage(isRestart);

        while (isCycle) {
            int userNumbers = inputView.enterAnswerNumber(outputView);

            String resultMessage = resultCheck.numberCheck(answerNumber, userNumbers);
            outputView.printResultMessage(resultMessage);

            boolean isCorrectAnswer = outputView.isCorrectAnswer(resultMessage);
            int gameResult = inputView.selectRestart(isCorrectAnswer);

            selectRestartGame(gameResult);
        }
    }

    private void selectRestartGame(int gameResult) {
        if (gameResult == RESTART_NUMBER) {
            startGame(true);
        }

        if (gameResult == END_NUMBER) {
            isCycle = false;
        }
    }

}
