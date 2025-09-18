package com.rudra.blog_java.startup;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.rudra.blog_java.models.Privilege;
import com.rudra.blog_java.models.User;
import com.rudra.blog_java.repositories.PrivilegeRepository;
import com.rudra.blog_java.repositories.UserRepository;
import com.rudra.blog_java.utils.DefaultUsers;

@Component
public class SeedAdmin implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PrivilegeRepository privilegeRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Seed admin user logic here
        System.out.println("Seeding admin user...");
        
        for (DefaultUsers defaultUser : DefaultUsers.values()) {
            // Check if user already exists
            Optional<User> existingUser = userRepository.findByEmail(defaultUser.getEmail());
            
            if (existingUser.isPresent()) {
                System.out.println("User " + defaultUser.getUsername() + " already exists. Skipping...");
                continue;
            }
            
            // Create user
            User user = User.builder()
                .username(defaultUser.getUsername())
                .email(defaultUser.getEmail())
                .role(defaultUser.getRole())
                .firstName(defaultUser.getFirstName())
                .lastName(defaultUser.getLastName())
                .password(passwordEncoder.encode("password")) // Default password, should be changed on first login
                .profileImage("/images/default-profile.png") // Default profile image
                .build();
            
            // Set privileges
            Set<Privilege> privileges = new HashSet<>();
            for (String privilegeName : defaultUser.getPrivileges()) {
                // Find or create privilege
                Privilege privilege = privilegeRepository.findByName(privilegeName)
                    .orElseGet(() -> {
                        Privilege newPrivilege = new Privilege();
                        newPrivilege.setName(privilegeName);
                        return privilegeRepository.save(newPrivilege);
                    });
                
                privileges.add(privilege);
            }
            
            user.setPrivileges(privileges);
            
            // Save user
            User savedUser = userRepository.save(user);
            System.out.println("Created user: " + savedUser.getUsername() + " with role: " + savedUser.getRole());
        }
    }
}
