package com.rudra.blog_java.utils;

public enum Privileges {
    CAN_ACCESS_DASHBOARD(1L, "CAN_ACCESS_DASHBOARD"),
    READ_PRIVILEGE(2L, "READ_PRIVILEGE"),
    WRITE_PRIVILEGE(3L,"WRITE_PRIVILEGE"),
    DELETE_PRIVILEGE(4L, "DELETE_PRIVILEGE");

    private final String name;
    private final Long id;

    Privileges(Long id, String name) {
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
