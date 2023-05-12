package com.example.jdbcboard.controller;

import com.example.jdbcboard.domain.User;
import com.example.jdbcboard.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    public String userList(Model model) {
        List<User> users = userService.findAll();

        model.addAttribute("users", users);

        return "user/list";
    }

    @PostMapping("/user")
    public String signup(@Valid UserForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "user/signup";
        }

        User user = new User();
        User createUser = user.setUserInfo(form);
        userService.join(createUser);

        return "redirect:/";
    }
}
