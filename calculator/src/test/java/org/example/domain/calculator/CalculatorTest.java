package org.example.domain.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * 간단한 사칙연산을 할 수 있다.
 * 양수로만 계산할 수 있다.
 * 나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.
 * MVC 패턴(Model-View-Controller) 기반으로 구현한다.
 */

class CalculatorTest {
    
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    @DisplayName("사칙연산을 정상적으로 수행한다.")
    void calculateTest(int leftHandSide, String operator, int rightHandSide, int calculateResult) {
        Calculator calculator = new Calculator();
        int result = calculator.calculate(leftHandSide, operator, rightHandSide);
    
        assertThat(result).isEqualTo(calculateResult);
    }
    
    private static Stream<Arguments> formulaAndResult() {
        return Stream.of(
            Arguments.arguments(1, "+", 2, 3),
            Arguments.arguments(1, "-", 2, -1),
            Arguments.arguments(4, "*", 2, 8),
            Arguments.arguments(4, "/", 2, 2)
        );
    }
    
    @DisplayName("나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.")
    @Test
    void calculateExceptionTest() {
        Calculator calculator = new Calculator();
    
        assertThatCode(() -> calculator.calculate(10, "/", 0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("0으로 나눌 수 없습니다.");
    }
}