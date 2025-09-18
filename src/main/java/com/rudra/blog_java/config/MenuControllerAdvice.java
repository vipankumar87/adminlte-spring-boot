package com.rudra.blog_java.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.rudra.blog_java.services.MenuService;

import java.util.List;
import com.rudra.blog_java.utils.AdminMenu;

@ControllerAdvice
public class MenuControllerAdvice {
    
    private final MenuService menuService;
    
    public MenuControllerAdvice(MenuService menuService) {
        this.menuService = menuService;
    }
    
    /**
     * Add admin menus to all model attributes automatically
     * This makes the menu available in all controllers without explicitly adding it
     */
    @ModelAttribute("adminMenus")
    public List<AdminMenu> getAdminMenus() {
        return menuService.getAdminMenus();
    }
}
