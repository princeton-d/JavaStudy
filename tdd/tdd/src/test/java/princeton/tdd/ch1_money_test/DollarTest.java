package princeton.tdd.ch1_money_test;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class DollarTest {

    @Test
    public void testMultiplication() throws Exception {
        Money five = Money.dollar(5);

        assertThat(Money.dollar(10)).isEqualTo(five.times(2));
        assertThat(Money.dollar(15)).isEqualTo(five.times(3));
    }

    @Test
    public void testEquality() throws Exception {
        assertThat(Money.dollar(5).equals(Money.dollar(5))).isTrue();
        assertThat(Money.dollar(5).equals(Money.dollar(6))).isFalse();
        assertThat(Money.franc(5).equals(Money.franc(5))).isTrue();
        assertThat(Money.franc(5).equals(Money.franc(6))).isFalse();
        assertThat(Money.franc(5).equals(Money.dollar(5))).isFalse();
    }

    @Test
    public void testFrancMultiplication() throws Exception {
        Money five = Money.franc(5);

        assertThat(Money.franc(10)).isEqualTo(five.times(2));
        assertThat(Money.franc(15)).isEqualTo(five.times(3));
    }

}

/*
충분한 테스트가 없다면 지원 테스트가 갖춰지지 않은 리팩토링을 만나게 될 수밖에 없다.
리팩토링하면서 실수했는데도 불구하고 테스트가 여전히 통과할 수도 있는 것이다. 어떻게 할 텐가?
있으면 좋을 것 같은 테스트를 작성하라.
그렇게 하지 않으면 결국에는 리팩토링하다가 뭔가 깨트릴 것이다.
그러면 여러분은 리팩토링에 대해 안 좋은 느낌을 갖게 되고, 리팩토링을 덜 하게 된다.
리팩토링을 더 적게 하면 설계의 질이 저하되고, 결국 여러분은 해고될 것이다.
여러분의 강아지도 곁을 떠날 것이고, 여러분은 자신의 영양 상태에 신경을 쓰지 못하게 될 것이다.
그러면 이도 나빠진다. 자, 이를 건강하게 유지하기 위해 리팩토링하기 전에 테스팅을 하자.
*/