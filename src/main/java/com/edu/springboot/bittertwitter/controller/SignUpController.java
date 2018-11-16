package com.edu.springboot.bittertwitter.controller;

import com.edu.springboot.bittertwitter.entity.User;
import com.edu.springboot.bittertwitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {
    private final UserService userService;

    @Autowired
    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/sign-up")
    public String showSignUp() {
        return "sign-up";
    }

    @PostMapping("/sign-up")
    public String addUser(User user, Model model) {
        if (userService.addUser(user)) {
            return "redirect:/sign-in";
        }

        model.addAttribute("info", "User with such username already exists");
        return "/sign-up";
    }

    @GetMapping("/activate/{code}")
    public String activateUser(
            @PathVariable String code,
            Model model) {

        boolean isActivated = userService.activateUser(code);

        if (isActivated) {
            String ok = "User is successfully activated";
            model.addAttribute("message", ok);
        } else {
            String fail = "User activation failed";
            model.addAttribute("message", fail);
        }
        return "sign-in";

    }
}
