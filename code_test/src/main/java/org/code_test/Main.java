package org.code_test;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String[] arr = {"1", "3", "-2", "9", "6", "5"};

        int[] intArr = Arrays.stream(arr)
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        System.out.println(Arrays.toString(intArr));
    }
}