package org.example.view;

import org.example.util.Validate;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int enterAnswerNumber(OutputView outputView) {
        outputView.printEnterAnswerGuid();

        return nextInteger();
    }

    private int nextInteger() {
        String inputValue = scanner.nextLine();
        Validate.numberFormat(inputValue);

        return Integer.parseInt(inputValue);
    }

}
