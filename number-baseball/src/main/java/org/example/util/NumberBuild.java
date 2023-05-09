package org.example.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberBuild {

    public static List<Integer> buildNumbers(int userNumbers) {
        String[] splitNumbers = String.valueOf(userNumbers).split("");

        return createNumberArr(splitNumbers);
    }

    private static List<Integer> createNumberArr(String[] splitNumbers) {
        return Stream.of(splitNumbers)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
