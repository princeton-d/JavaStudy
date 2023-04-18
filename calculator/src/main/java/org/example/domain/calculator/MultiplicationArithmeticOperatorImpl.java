package org.example.domain.calculator;

public class MultiplicationArithmeticOperatorImpl implements ArithmeticOperator{
    @Override
    public boolean supports(String operator) {
        return operator.equals("*");
    }
    
    @Override
    public int calculate(int leftHandSide, int rightHandSide) {
        return leftHandSide * rightHandSide;
    }
}
