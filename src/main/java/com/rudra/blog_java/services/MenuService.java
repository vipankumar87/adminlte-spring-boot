package com.rudra.blog_java.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rudra.blog_java.providers.MenuProvider;
import com.rudra.blog_java.utils.AdminMenu;

@Service
public class MenuService {
    
    private final MenuProvider menuProvider;
    
    public MenuService(MenuProvider menuProvider) {
        this.menuProvider = menuProvider;
    }
    
    public List<AdminMenu> getAdminMenus() {
        return menuProvider.getAdminMenus();
    }
    
    /**
     * Find a menu item by its link path
     * @param link The link to search for
     * @return The matching menu item or null if not found
     */
    public AdminMenu findMenuByLink(String link) {
        return findMenuByLinkRecursive(menuProvider.getAdminMenus(), link);
    }
    
    private AdminMenu findMenuByLinkRecursive(List<AdminMenu> menus, String link) {
        for (AdminMenu menu : menus) {
            if (link.equals(menu.getLink())) {
                return menu;
            }
            
            if (!menu.getChildren().isEmpty()) {
                AdminMenu found = findMenuByLinkRecursive(menu.getChildren(), link);
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }
}
