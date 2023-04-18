package org.example.domain.calculator;

public interface ArithmeticOperator {
    boolean supports(String operator);
    
    int calculate(int leftHandSide, int rightHandSide);
}
