package org.example;

import org.example.domain.AnswerNumbers;
import org.example.domain.ResultCheck;
import org.example.view.InputView;
import org.example.view.OutputView;

public class Game {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final ResultCheck resultCheck = new ResultCheck();
    private boolean cycle = true;

    public void startGame(boolean isRestart) {

        AnswerNumbers answerNumber = new AnswerNumbers();

        outputView.printStartMessage(isRestart);
        int userNumbers = inputView.enterAnswerNumber(outputView);

        String resultMessage = resultCheck.numberCheck(answerNumber, userNumbers);
        outputView.printResultMessage(resultMessage);

        boolean isCorrectAnswer = outputView.isCorrectAnswer(resultMessage);

        while (cycle) {
            int result = inputView.nextStep(outputView, isCorrectAnswer);

            if (result == 1) {
                startGame(true);
            }

            if (result == 2) {
                cycle = false;
            }
        }
        //        boolean isRestartGame = inputView.selectRestartGame()

    }

}
