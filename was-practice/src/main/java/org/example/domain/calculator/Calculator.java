package org.example.domain.calculator;

import java.util.List;

public class Calculator {
    private static final List<ArithmeticOperator> arithmeticOperators = List.of(new AdditionArithmeticOperatorImpl(), new SubtractionArithmeticOperatorImpl(), new MultiplicationArithmeticOperatorImpl(), new DivisionArithmeticOperatorImpl());

    public int calculate(PositiveNumber leftHandSide, String operator, PositiveNumber rightHandSide) {
//        return ArithmeticOperatorImpl.calculate(leftHandSide, operator, rightHandSide);
        return arithmeticOperators.stream()
            .filter(arithmeticOperator -> arithmeticOperator.supports(operator))
            .map(arithmeticOperator -> arithmeticOperator.calculate(leftHandSide, rightHandSide))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
