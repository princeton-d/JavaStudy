import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        System.out.println(solution("browoanoommnaon"));
    }

    public static String solution(String str) {
        List<String> list = Arrays.asList(str.split(""));
        int count = 0;

        while (true) {
            if (list.get(count).equals(list.get(count + 1))) {
                list.remove(count + 1);
                list.remove(count + 2);
                count--;
                continue;
            }
            count++;
            if (list.get(count).equals("")) {
                break;
            }
        }

        return String.join("", list);
    }
}
