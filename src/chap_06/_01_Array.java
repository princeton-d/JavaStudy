package chap_06;

public class _01_Array {
  public static void main(String[] args) {
    int[] array1 = new int[100];

    array1[0] = 50;
    array1[50] = 100;

    int[] array2 = new int[]{1, 2, 3, 4};

    int[] array3 = {1, 2, 3, 4};

    System.out.println(array3[3]);

    int value = array3[0];

  }
}
