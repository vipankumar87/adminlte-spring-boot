package com.rudra.blog_java.utils;

public enum Roles {
    ADMIN(1L, "ADMIN"),
    EDITOR(2L, "EDITOR"),
    USER(3L, "USER");

    private final Long id;
    private final String name;

    Roles(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
