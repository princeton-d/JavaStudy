package generic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SetTest {
    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(1);
        values.add(3);
    
        Set<Integer> duplicate = findDuplicate(values);
    
        System.out.println(duplicate);
    }
    
    public static Set<Integer> findDuplicate(List<Integer> values) {
        Set<Integer> seen = new HashSet<>();
    
        return values.stream()
            .filter(e -> !seen.add(e))
            .collect(Collectors.toSet());
    }
}
