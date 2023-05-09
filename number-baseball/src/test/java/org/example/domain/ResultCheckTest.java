package org.example.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResultCheckTest {

    @Test
    public void 숫자_매칭_결과() throws Exception {
        //given
        AnswerNumbers answerNumbers = new AnswerNumbers();
        ResultCheck resultCheck = new ResultCheck();
        int testUserNumbers = 739;


        //when
        resultCheck.numberCheck(answerNumbers, testUserNumbers);

        //then

    }

}