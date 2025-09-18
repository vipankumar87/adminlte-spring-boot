package com.rudra.blog_java.utils;

import java.util.ArrayList;
import java.util.List;


public class AdminMenu {
    private String title;
    private String icon;
    private String link;
    private List<AdminMenu> children = new ArrayList<>();

    public AdminMenu(String title, String icon, String link) {
        this.title = title;
        this.icon = icon;
        this.link = link;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getIcon() {
        return icon;
    }


    public void setIcon(String icon) {
        this.icon = icon;
    }


    public String getLink() {
        return link;
    }


    public void setLink(String link) {
        this.link = link;
    }


    public List<AdminMenu> getChildren() {
        return children;
    }


    public void setChildren(List<AdminMenu> children) {
        this.children = children;
    }


    public void addChild(AdminMenu child) {
        this.children.add(child);
    }
}