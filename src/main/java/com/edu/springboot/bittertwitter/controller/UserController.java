package com.edu.springboot.bittertwitter.controller;

import com.edu.springboot.bittertwitter.entity.Role;
import com.edu.springboot.bittertwitter.entity.User;
import com.edu.springboot.bittertwitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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

    @PostMapping
    public String saveEditedUser(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("user_id") User user, Model model
    ){
        user.setUsername(username);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()){
            if (roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userService.save(user);
        return "redirect:/user";
    }


    @GetMapping("{user}")
    public String showUserEditor(@PathVariable User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "user-editor";

    }
}
