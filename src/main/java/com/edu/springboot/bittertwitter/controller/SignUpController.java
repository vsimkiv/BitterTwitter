package com.edu.springboot.bittertwitter.controller;

import com.edu.springboot.bittertwitter.entity.Role;
import com.edu.springboot.bittertwitter.entity.User;
import com.edu.springboot.bittertwitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

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
        UserDetails userFromDB = userService.loadUserByUsername(user.getUsername());

        if (userFromDB != null) {
            model.addAttribute("info", "User with such username already exists");
            return "/sign-up";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userService.save(user);

        return "redirect:/sign-in";
    }
}
