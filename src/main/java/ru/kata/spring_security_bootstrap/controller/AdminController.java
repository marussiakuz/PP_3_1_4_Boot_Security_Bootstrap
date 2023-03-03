package ru.kata.spring_security_bootstrap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring_security_bootstrap.model.UserInDto;
import ru.kata.spring_security_bootstrap.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getListOfUsers(ModelMap model) {
        model.addAttribute("users", userService.getAll());
        return "admin";
    }

    @PostMapping
    public String create(@RequestBody UserInDto user) {
        userService.create(user);
        return "admin";
    }

    @PatchMapping("/user/{id}")
    public String update(@PathVariable long id, @RequestBody UserInDto user) {
        userService.update(id, user);
        return "admin";
    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable("id") long id, ModelMap model) {
        userService.delete(id);
        return "admin";
    }
}
