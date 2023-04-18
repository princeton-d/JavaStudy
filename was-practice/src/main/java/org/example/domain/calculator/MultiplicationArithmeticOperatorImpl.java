package org.example.domain.calculator;

public class MultiplicationArithmeticOperatorImpl implements ArithmeticOperator{
    @Override
    public boolean supports(String operator) {
        return operator.equals("*");
    }
    
    @Override
    public int calculate(PositiveNumber leftHandSide, PositiveNumber rightHandSide) {
        return leftHandSide.toInt() * rightHandSide.toInt();
    }
}
