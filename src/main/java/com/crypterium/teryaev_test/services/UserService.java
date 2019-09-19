package com.crypterium.teryaev_test.services;


import com.crypterium.teryaev_test.entities.authenticate.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByUsername(String username);
}
