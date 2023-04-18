package org.example.domain.calculator;

public interface ArithmeticOperator {
    boolean supports(String operator);
    
    int calculate(PositiveNumber leftHandSide, PositiveNumber rightHandSide);
}
