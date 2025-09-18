package com.rudra.blog_java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rudra.blog_java.config.RudraUserDetails;
import com.rudra.blog_java.models.User;
import com.rudra.blog_java.repositories.UserRepository;
import org.hibernate.Hibernate;

@Service
public class UserService implements UserDetailsService{
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userOpt = userRepository.findByUsernameOrEmail(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        
        // Initialize the privileges collection within the transaction
        if (userOpt.getPrivileges() != null) {
            Hibernate.initialize(userOpt.getPrivileges());
        }
        
        return new RudraUserDetails(userOpt);
    }
}
