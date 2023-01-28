package chap_06;

public class _02_Array2 {
  public static void main(String[] args) {
    int[] array1 = new int[100];
    array1[0] = 1;
    array1[1] = 2;

//    for (int i = 0; i < array1.length; i++) {
//      array1[i] = i + 1;
//      System.out.println(array1[i]);
//    }

    int num = 0;
    for (int i = 0; i < array1.length; i++) {
      array1[i] = ++num;
      System.out.println(array1[i]);
    }
  }
}
