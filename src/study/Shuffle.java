package study;

import java.util.Arrays;

public class Shuffle {
    public int[] shuffle(int[] intArray) {

        for (int i = 0; i < 100; i++) {
            int n = (int) (Math.random() * 9); // 0 ~ 8
            int tmp = intArray[0];
            intArray[0] = intArray[n];
            intArray[n] = tmp;
        }

        return intArray;
    }


//    public static void main(String[] args) {
//
//        int[] original = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        System.out.println(Arrays.toString(original));
//
//        int[] result = shuffle(original);
//        System.out.println(Arrays.toString(result));
//    }
}
