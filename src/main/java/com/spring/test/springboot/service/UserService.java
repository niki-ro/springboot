package com.spring.test.springboot.service;

import com.spring.test.springboot.domain.User;

public interface UserService {
    User findByLogin(String login);
    void addUser(User user);
}
