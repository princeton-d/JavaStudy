package org.example.util;

import java.util.HashSet;
import java.util.Set;

public class Validate {

    public static void numberFormat(String inputValue) {
        try {
            int intValue = Integer.parseInt(inputValue);
            numberSize(intValue);
            duplicateNumber(intValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자는 공백 없이 숫자만 입력해주세요.");
        }
    }

    private static void numberSize(int intValue) {
        if (intValue < 100 || intValue > 999) {
            throw new IllegalArgumentException("숫자는 0을 제외한 3자리의 서로 중복되지 않은 숫자만 입력해주세요");
        }
    }

    private static void duplicateNumber(int intValue) {
        String[] splitValue = String.valueOf(intValue).split("");
        Set<String> set = new HashSet<>();

        set.add(splitValue[0]);
        set.add(splitValue[1]);
        set.add(splitValue[2]);

        if (set.size() < splitValue.length || set.contains("0")) {
            throw new IllegalArgumentException("숫자는 0을 제외한 중복이 없는 숫자만 입력해주세요");
        }
    }

}
