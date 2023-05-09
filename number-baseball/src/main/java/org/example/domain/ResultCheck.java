package org.example.domain;

import org.example.util.NumberBuild;

import java.util.List;

public class ResultCheck {
    private final String STRIKE = "스트라이크";
    private final String BALL = "볼";
    private final String NOTHING = "낫싱";
    private final int FIRST_NUMBER_COUNT = 0;
    private final int CENTER_NUMBER_COUNT = 1;
    private final int LAST_NUMBER_COUNT = 2;

    public String numberCheck(AnswerNumbers answerNumbers, int userNumbers) {
        List<Integer> userNumberArr = NumberBuild.buildNumbers(userNumbers);

        int strikeCount = strikeCheck(answerNumbers, userNumberArr);
        int ballCount = ballCheck(answerNumbers, userNumberArr, strikeCount);

        return resultBuild(strikeCount, ballCount);
    }

    private int strikeCheck(AnswerNumbers answerNumbers, List<Integer> userNumbers) {
        int strikeCount = 0;
        int userFirstNumber = userNumbers.get(FIRST_NUMBER_COUNT);
        int userCenterNumber = userNumbers.get(CENTER_NUMBER_COUNT);
        int userLastNumber = userNumbers.get(LAST_NUMBER_COUNT);

        if (answerNumbers.getFirstNumber() == userFirstNumber) {
            strikeCount++;
        }

        if (answerNumbers.getCenterNumber() == userCenterNumber) {
            strikeCount++;
        }

        if (answerNumbers.getLastNumber() == userLastNumber) {
            strikeCount++;
        }

        return strikeCount;
    }

    private int ballCheck(AnswerNumbers answerNumbers, List<Integer> userNumbers, int strikeCount) {
        int ballCount = -strikeCount;

        if (isContains(userNumbers, answerNumbers.getFirstNumber())) {
            ballCount++;
        }

        if (isContains(userNumbers, answerNumbers.getCenterNumber())) {
            ballCount++;
        }

        if (isContains(userNumbers, answerNumbers.getLastNumber())) {
            ballCount++;
        }

        return ballCount;
    }

    private String resultBuild(int strikeCount, int ballCount) {
        if (ballCount == 0 && strikeCount != 0) {
            return strikeCount + STRIKE;
        }

        if (ballCount == 0 && strikeCount == 0) {
            return NOTHING;
        }

        return ballCount + BALL + " " + strikeCount + STRIKE;
    }

    private boolean isContains(List<Integer> userNumbers, int answerNumber) {
        return userNumbers.contains(answerNumber);
    }
}
