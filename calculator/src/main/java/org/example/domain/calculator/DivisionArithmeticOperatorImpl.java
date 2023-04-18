package org.example.domain.calculator;

public class DivisionArithmeticOperatorImpl implements ArithmeticOperator{
    @Override
    public boolean supports(String operator) {
        return operator.equals("/");
    }

    @Override
    public int calculate(int leftHandSide, int rightHandSide) {
        if (rightHandSide == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return leftHandSide / rightHandSide;
    }
}
