package com.rudra.blog_java.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
public class FrontendController {
    @GetMapping("/")
    public String index() {
        return "frontend/index";
    }    

    @GetMapping("/about")
    public String about() {
        return "frontend/about";
    }
    
    @GetMapping("/contactus")
    public String contactUs() {
        return "frontend/contact";
    }

    @PostMapping("/contactus")
    public String postContactUs(@RequestBody String entity) {
        return "redirect:/contactus";
    }
    
}
