package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Maps {
  public static void main(String[] args) {
    Map<Long, String> map = new HashMap<>();

    map.put(1L, "one");
    map.put(2L, "two");
//    System.out.println(map.entrySet());

    ArrayList<Integer> list1 = new ArrayList(10);
    list1.add(new Integer(900));
    list1.add(new Integer(90));
    list1.add(new Integer(901));
    list1.add(new Integer(902));
    list1.add(new Integer(903));
    System.out.println(list1);

    ArrayList list2 = new ArrayList(list1.subList(1, 4));
    System.out.println(list2);

    Collections.sort(list1);
    System.out.println(list1);

    System.out.println(list1.containsAll(list2));

    list1.add(0, 1);
    System.out.println(list1.indexOf(1));

    list1.remove(0);
    System.out.println(list1.get(2));
  }
}
