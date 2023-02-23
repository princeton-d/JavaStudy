package test;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.lang.reflect.Array;
import java.util.*;

public class Maps {
  public static void main(String[] args) {
    Map<Long, String> map = new HashMap<>();

    map.put(1L, "one");
    map.put(2L, "two");
//    System.out.println(map.entrySet());

    ArrayList<Integer> list1 = new ArrayList<>();
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

    System.out.println(list1.get(0).getClass());

    Stack<Integer> s = new Stack<>();
    s.push(1);
    s.push(2);
    s.push(1);
    s.pop();
    System.out.println(s.peek());
    s.add(3);
    System.out.println(s.peek());
  }
}
