import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args) {
        List<String> collect = Stream.generate(() -> "stream")
                .limit(10)
                .collect(Collectors.toList());

    }
}