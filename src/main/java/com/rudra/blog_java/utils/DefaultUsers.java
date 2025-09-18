package com.rudra.blog_java.utils;

import java.util.List;

public enum DefaultUsers {
    VIPAN("Vipan","Kumar", "vipan", "vipan@rudracomputer.com", Roles.ADMIN.getName(), List.of(Privileges.CAN_ACCESS_DASHBOARD.getName(), Privileges.READ_PRIVILEGE.getName(), Privileges.WRITE_PRIVILEGE.getName(), Privileges.DELETE_PRIVILEGE.getName())),
    JOHN("John", "Doe", "johndoe", "john@rudracomputer.com", Roles.USER.getName(), List.of(Privileges.READ_PRIVILEGE.getName(), Privileges.WRITE_PRIVILEGE.getName(), Privileges.DELETE_PRIVILEGE.getName()));
    
    private final String firstName;
    private final String lastName;
    private final String username;
    private final String email;
    private final String role;
    private final List<String> privileges;
    
    DefaultUsers(String firstName, String lastName, String username, String email, String role, List<String> privileges) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.role = role;
        this.privileges = privileges;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getRole() {
        return role;
    }
    
    public List<String> getPrivileges() {
        return privileges;
    }
}
