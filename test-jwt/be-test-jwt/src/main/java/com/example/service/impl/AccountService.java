package com.example.service.impl;

import com.example.model.Account;
import com.example.repository.IAccountRepository;
import com.example.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Autowired
    IAccountRepository userRepository;

    @Override
    public Account findAccountByUsername(String username) {
        return userRepository.findAccountByUsername(username);
    }
}
