package com.example.service;

import com.example.model.Account;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUserService {
    Account findUserByUsername (String username);
}
