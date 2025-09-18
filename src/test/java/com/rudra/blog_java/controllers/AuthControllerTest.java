package com.rudra.blog_java.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(AuthController.class)
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testLoginEndpoint() throws Exception {
        // Test that the controller returns the correct view name
        mockMvc.perform(get("/login").with(SecurityMockMvcRequestPostProcessors.csrf()))
                .andExpect(view().name("auth/login"));
    }

    @Test
    @WithMockUser
    public void testLoginEndpointWhenAuthenticated() throws Exception {
        // Test that the controller returns the correct view name when user is authenticated
        mockMvc.perform(get("/login").with(SecurityMockMvcRequestPostProcessors.csrf()))
                .andExpect(view().name("auth/login"));
    }

    @Test
    public void testRegisterEndpoint() throws Exception {
        // Test that the controller returns the correct view name
        mockMvc.perform(get("/register").with(SecurityMockMvcRequestPostProcessors.csrf()))
                .andExpect(view().name("auth/register"));
    }

    @Test
    public void testForgotPasswordEndpoint() throws Exception {
        // Test that the controller returns the correct view name
        mockMvc.perform(get("/forgot-password").with(SecurityMockMvcRequestPostProcessors.csrf()))
                .andExpect(view().name("auth/forgot-password"));
    }

    @Test
    public void testResetPasswordEndpoint() throws Exception {
        // Test that the controller returns the correct view name
        mockMvc.perform(get("/reset-password").with(SecurityMockMvcRequestPostProcessors.csrf()))
                .andExpect(view().name("auth/reset-password"));
    }

    @Test
    public void testLogoutEndpoint() throws Exception {
        // Test that the controller returns the correct view name
        mockMvc.perform(get("/logout").with(SecurityMockMvcRequestPostProcessors.csrf()))
                .andExpect(view().name("auth/logout"));
    }
}