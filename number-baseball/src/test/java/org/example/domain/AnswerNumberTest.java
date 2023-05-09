package org.example.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class AnswerNumberTest {

    @Test
    @DisplayName("정답 숫자는 모두 다른 숫자여야한다.")
    public void 정답_숫자_중복_테스트() throws Exception {
        //given
        AnswerNumbers answerNumber = new AnswerNumbers();

        //when
        int firstNumber = answerNumber.getFirstNumber();
        int centerNumber = answerNumber.getCenterNumber();
        int lastNumber = answerNumber.getLastNumber();

        //then
        assertThat(firstNumber)
                .isNotEqualTo(centerNumber)
                .isNotEqualTo(lastNumber);

        assertThat(centerNumber).isNotEqualTo(lastNumber);
    }

}