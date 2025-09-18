package com.rudra.blog_java.providers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rudra.blog_java.utils.AdminMenu;

import jakarta.annotation.PostConstruct;

@Component
public class MenuProvider {
    
    private List<AdminMenu> adminMenus = new ArrayList<>();
    
    @PostConstruct
    public void init() {
        // Dashboard
        AdminMenu dashboard = new AdminMenu("Dashboard", "bi bi-speedometer", "/admin/dashboard");
        
        // Users Management
        AdminMenu users = new AdminMenu("Users", "bi bi-people-fill", "#");
        users.addChild(new AdminMenu("All Users", "bi bi-circle", "/admin/users"));
        users.addChild(new AdminMenu("Add User", "bi bi-circle", "/admin/users/create"));
        users.addChild(new AdminMenu("User Roles", "bi bi-circle", "/admin/roles"));
        
        // Content Management
        AdminMenu content = new AdminMenu("Content", "bi bi-file-earmark-text-fill", "#");
        content.addChild(new AdminMenu("Posts", "bi bi-circle", "/admin/posts"));
        content.addChild(new AdminMenu("Categories", "bi bi-circle", "/admin/categories"));
        content.addChild(new AdminMenu("Tags", "bi bi-circle", "/admin/tags"));
        
        // Settings
        AdminMenu settings = new AdminMenu("Settings", "bi bi-gear-fill", "#");
        settings.addChild(new AdminMenu("General", "bi bi-circle", "/admin/settings/general"));
        settings.addChild(new AdminMenu("Email", "bi bi-circle", "/admin/settings/email"));
        settings.addChild(new AdminMenu("Security", "bi bi-circle", "/admin/settings/security"));
        
        // Add all top-level menus
        adminMenus.add(dashboard);
        adminMenus.add(users);
        adminMenus.add(content);
        adminMenus.add(settings);
    }
    
    public List<AdminMenu> getAdminMenus() {
        return adminMenus;
    }
}
