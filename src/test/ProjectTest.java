package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProjectTest {
    
    public static void main(String[] args) {
//        System.out.println((int)Math.ceil(Math.random()*2));
    
        List<Integer> list = new ArrayList<>();
    
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(2);
        Collections.sort(list);
    
        System.out.println(list);
    }
}
