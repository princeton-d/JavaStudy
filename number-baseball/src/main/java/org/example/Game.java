package org.example;

import org.example.domain.AnswerNumber;
import org.example.view.InputView;
import org.example.view.OutputView;

public class Game {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void startGame() {

        final AnswerNumber answerNumber = AnswerNumber.getInstance();

        outputView.printStartMessage();
        int userNumber = inputView.enterAnswerNumber(outputView);



    }

}
