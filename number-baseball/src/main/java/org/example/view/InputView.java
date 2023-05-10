package org.example.view;

import org.example.util.Validate;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int enterAnswerNumber(OutputView outputView) {
        outputView.printEnterAnswerGuid();

        return nextInteger();
    }

    public int selectRestart(boolean isCorrectAnswer) {
        int emptyNumber = 0; //크게 의미 없는 숫자

        if (isCorrectAnswer) {
            String resultInput = scanner.nextLine();
            Validate.resultInputFormat(resultInput);

            return Integer.parseInt(resultInput);
        }

        return emptyNumber;
    }

    private int nextInteger() {
        String inputValue = scanner.nextLine();
        Validate.numberFormat(inputValue);

        return Integer.parseInt(inputValue);
    }

}
