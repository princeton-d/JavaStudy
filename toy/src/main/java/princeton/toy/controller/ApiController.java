package princeton.toy.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import princeton.toy.domain.User;
import princeton.toy.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final UserService userService;

    @GetMapping("/api/users")
    @ResponseBody
    public Result getUsers() {
        List<User> findUsers = userService.findUsers();
        return new Result(findUsers, findUsers);

    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T users;
        private T users2;
    }
}
