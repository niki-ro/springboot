package com.spring.test.springboot.controller;

import com.spring.test.springboot.domain.User;
import com.spring.test.springboot.domain.UserRole;
import com.spring.test.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {
    @Autowired
    private UserService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String registrationNewUser(@RequestParam String login, @RequestParam String password, Model model){
        String problem;
        String message;
        String encodePassword;
        if(service.findByLogin(login) != null) {
            problem = "Login is already exist!";
            model.addAttribute("problem",problem);
            return "registration";
        }
        else {
            if (login.length() < 8 || password.length() < 8) {
                problem = "The minimum length of the login and password is 8 characters! Please " +
                        "enter again.";
                model.addAttribute("problem", problem);
                return "registration";
            }
            else if (login.length() > 32 || password.length() > 32){
                problem = "The maximum length of the login and password is 32 characters! Please " +
                        "enter again.";
                model.addAttribute("problem", problem);
                return "registration";
            }
            else {
                encodePassword = passwordEncoder.encode(password);
                User user = new User(login, encodePassword, UserRole.USER);
                service.addUser(user);
                message = "Registration success! Please sign in";
                model.addAttribute("message", message);
                return "index";
            }
        }
    }
}
