package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnePageCode {

  public static void main(String[] args) {

    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    Scanner nameInputValue = new Scanner(System.in);
    String nameInput = nameInputValue.nextLine();
    String[] names = nameInput.split(",");
    List<String> nameArr = new ArrayList<>();
    for (String name : names) {
      nameArr.add(name);
    }

    System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요");
    Scanner resultInputValue = new Scanner(System.in);
    String resultInput = resultInputValue.nextLine();
    String[] results = resultInput.split(",");
    List<String> resultArr = new ArrayList<>();
    for (String result : results) {
      resultArr.add(result);
    }

    System.out.println("\n최대 사다리 높이는 몇 개인가요?");
    Scanner maxHeightValue = new Scanner(System.in);
    int maxHeight = maxHeightValue.nextInt();

    System.out.println("\n사다리 결과");

    System.out.println("\n" + String.join(" ", nameArr));
  }
}
