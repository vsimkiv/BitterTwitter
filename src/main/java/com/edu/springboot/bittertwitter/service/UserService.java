package com.edu.springboot.bittertwitter.service;

import com.edu.springboot.bittertwitter.entity.Role;
import com.edu.springboot.bittertwitter.entity.User;
import com.edu.springboot.bittertwitter.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {
    private final UserRepo userRepo;
    private final MailSender mailSender;

    @Autowired
    public UserService(UserRepo userRepo, MailSender mailSender) {
        this.userRepo = userRepo;
        this.mailSender = mailSender;
    }

    public User save(User user) {
        return userRepo.save(user);
    }

    public Iterable<User> loadAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

    public boolean addUser(User user) {
        UserDetails userFromDB = userRepo.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setActivationCode(UUID.randomUUID().toString());

        if(!StringUtils.isEmpty(user.getEmail())){
            String text = String.format("Hello %s! \n " +
                            "Welcome to BitterTwitter! " +
                            "To confirm your registration please follow this link:" +
                            "http://localhost:8080/activate/%s",
                    user.getEmail(),
                    user.getActivationCode());

                    mailSender.send(
                    user.getEmail(),
                    "Confirm your registration on BitterTwitter",
                    text);
        }

        userRepo.save(user);
        return true;
    }

    public boolean activateUser(String code) {
        User user = userRepo.findUserByActivationCode(code);

        if (user == null) {
            return false;
        }

        user.setActivationCode(null);
        userRepo.save(user);

        return true;
    }
}
