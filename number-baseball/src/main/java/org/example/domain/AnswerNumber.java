package org.example.domain;

import java.util.*;

public class AnswerNumber {

    private static final AnswerNumber INSTANCE = new AnswerNumber();
    private final int MAX_NUMBER = 9;

    private int firstNumber;
    private int centerNumber;
    private int lastNumber;

    private AnswerNumber() {
        Iterator<Integer> numbers = answerNumberBuild();
        this.firstNumber = numbers.next();
        this.centerNumber = numbers.next();
        this.lastNumber = numbers.next();
    }

    public static AnswerNumber getInstance() {
        return INSTANCE;
    }

    private Iterator<Integer> answerNumberBuild() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 3) {
            int randomNumber = createRandomNumber();

            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        return numbers.iterator();
    }

    private int createRandomNumber() {
        return (int) (Math.random() * MAX_NUMBER) + 1;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getCenterNumber() {
        return centerNumber;
    }

    public int getLastNumber() {
        return lastNumber;
    }
}
