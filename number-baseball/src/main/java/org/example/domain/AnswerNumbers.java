package org.example.domain;

import java.util.*;

public class AnswerNumbers {

    private final int MAX_NUMBER = 9;

    private final int firstNumber;
    private final int centerNumber;
    private final int lastNumber;

    public AnswerNumbers() {
        Iterator<Integer> numbers = NumberBuild();
        this.firstNumber = numbers.next();
        this.centerNumber = numbers.next();
        this.lastNumber = numbers.next();
    }

    private Iterator<Integer> NumberBuild() {
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
