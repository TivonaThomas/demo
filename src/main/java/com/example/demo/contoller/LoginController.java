package com.example.demo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repository.UserRepository;

import org.springframework.ui.Model;

@Controller
public class LoginController {
    @Autowired
    private UserRepository repo;
    
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
    
    @PostMapping("/login")
public String login(@RequestParam String username,
                    @RequestParam String password,
                    Model model) {

    if(repo.findByUsernameAndPassword(username, password) != null) {
        return "home";
    } else {
        model.addAttribute("error", "Invalid Credentials");
        return "login";
    }
}
    
}
