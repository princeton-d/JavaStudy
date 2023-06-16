package princeton.princeton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}


//    int answer = 0;
//        for (int i = 0; i < arr.length; i++) {
//        answer += arr[i];
//        }
//        return (double)answer / arr.length;