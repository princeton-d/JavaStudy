package enum_test;

import java.math.BigDecimal;
import java.util.Arrays;

public enum EnumTest {
    
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);
    
    
    private final int matching;
    private final BigDecimal reward;
    
    EnumTest(int matching, int reward) {
        this.matching = matching;
        this.reward = new BigDecimal(reward);
    }
    
    public EnumTest getRank(int matching, boolean bonusNumber) {
        if (matching == 5 && bonusNumber) {
            return SECOND;
        }
    
        return Arrays.stream(values())
            .filter(rating -> rating.matching == matching)
            .findAny()
            .orElseThrow(IllegalAccessError::new);
    }
    
    public int getMatching() {
        return matching;
    }
    
    public BigDecimal getReward() {
        return reward;
    }
}
