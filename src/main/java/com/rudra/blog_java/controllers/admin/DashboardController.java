package com.rudra.blog_java.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class DashboardController {

    @RequestMapping({"","/","/dashboard"})
    public String dashboard() {
        return "admin/dashboard";
    }
    
}
