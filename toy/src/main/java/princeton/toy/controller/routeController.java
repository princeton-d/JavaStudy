package princeton.toy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import princeton.toy.domain.User;
import princeton.toy.service.UserService;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class routeController {

    private final UserService userService;

    private boolean isNotCreateTestData = true;

    @GetMapping("/")
    public String home() {
        createTestData();
        return "index";
    }

    @GetMapping("/users/userList")
    public String userList() {

        return "users/userList";
    }

    private void createTestData() {
        if (isNotCreateTestData) {
            User user1 = User.builder()
                    .username("memberA")
                    .userLoginId("princetonA")
                    .userPassword("password")
                    .createdAt(LocalDateTime.now())
                    .build();
            User user2 = User.builder()
                    .username("memberB")
                    .userLoginId("princetonB")
                    .userPassword("password")
                    .createdAt(LocalDateTime.now())
                    .build();
            User user3 = User.builder()
                    .username("memberC")
                    .userLoginId("princetonC")
                    .userPassword("password")
                    .createdAt(LocalDateTime.now())
                    .build();
            userService.join(user1);
            userService.join(user2);
            userService.join(user3);

            isNotCreateTestData = !isNotCreateTestData;
        }
    }
}
