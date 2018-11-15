package com.edu.springboot.bittertwitter.controller;

import com.edu.springboot.bittertwitter.entity.Role;
import com.edu.springboot.bittertwitter.entity.User;
import com.edu.springboot.bittertwitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showUserList(Model model){
        model.addAttribute("users", userService.loadAllUsers());
        return "user-list";

    }

    @GetMapping("{user}")
    public String showUserEditor(@PathVariable User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "user-editor";

    }
}
