package com.rudra.blog_java.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    
    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }
    
    @GetMapping("/register")
    public String register() {
        return "auth/register";
    }

    @GetMapping("/forgot-password")
    public String forgotPassword() {
        return "auth/forgot-password";
    }
    
    @GetMapping("/reset-password")
    public String resetPassword() {
        return "auth/reset-password";
    }
    
    @GetMapping("/logout")
    public String logout() {
        return "auth/logout";
    }    
}
