package org.example.domain.calculator;

import java.util.Arrays;

public enum ArithmeticOperatorImpl {
    ADDITION("+") {
        @Override
        public int arithmeticCalculate(int leftHandSide, int rightHandSide) {
            return leftHandSide + rightHandSide;
        }
    }, SUBTRACTION("-") {
        @Override
        public int arithmeticCalculate(int leftHandSide, int rightHandSide) {
            return leftHandSide - rightHandSide;
        }
    }, MULTIPLICATION("*") {
        @Override
        public int arithmeticCalculate(int leftHandSide, int rightHandSide) {
            return leftHandSide * rightHandSide;
        }
    }, DIVISION("/") {
        @Override
        public int arithmeticCalculate(int leftHandSide, int rightHandSide) {
            return leftHandSide / rightHandSide;
        }
    };
    
    private final String operator;
    
    ArithmeticOperatorImpl(String operator) {
        this.operator = operator;
    }
    
    public abstract int arithmeticCalculate(final int leftHandSide, final int RightHandSide);
    
    public static int calculate(int leftHandSide, String operator, int rightHandSide) {
        ArithmeticOperatorImpl arithmeticOperatorImpl = Arrays.stream(values())
            .filter(v -> v.operator.equals(operator))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
        
        return arithmeticOperatorImpl.arithmeticCalculate(leftHandSide, rightHandSide);
    }
}
