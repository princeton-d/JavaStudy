import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args) {

        System.out.println(solution(580000));
    }
    public static int solution(int price) {
        int answer = 0;

        if(100000<=price){
            answer = (int)(price * 0.95);
        }

        if(300000<=price){
            answer = (int)(price * 0.90);
        }

        if(500000<=price){
            answer = (int)(price * 0.80);
        }

        if (price < 100000) {
            answer = price;
        }
        return answer;
    }
}

class Solution {
    public int solution(int price) {
        int answer = 0;
        if(100000<=price){
            answer = (int)(price * 0.95);
        }
        else if(300000<=price){
            answer = (int)(price * 0.90);
        }
        else if(500000<=price){
            answer = (int)(price * 0.80);
        } else {
            answer = price;
        }
        return answer;
    }
}