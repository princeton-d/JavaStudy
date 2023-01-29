package chap_06;

public class _03_Array3 {
  public static void main(String[] args) {
    int[][] array1 = new int[3][4];

    array1[0][0] = 10;

    System.out.println(array1[0][0]);

//    배열의 길이가 각각 다른 2차원 배열을 만들 수도 있다.
    int[][] array2 = new int[3][];
    array2[0] = new int[1];
    array2[1] = new int[2];
    array2[2] = new int[3];

    System.out.println(array2[0][0]);

    int[][] array3 = {{1}, {1, 2}, {1, 2, 3}};

    System.out.println(array3[0][0]);
  }
}
