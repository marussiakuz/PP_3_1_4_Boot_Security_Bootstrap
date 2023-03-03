package ru.kata.spring_security_bootstrap.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring_security_bootstrap.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUser(ModelMap model) {
        model.addAttribute("user", userService.getByEmail(SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName()));
        return "user";
    }
}
