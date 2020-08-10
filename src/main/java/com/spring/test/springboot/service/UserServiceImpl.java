package com.spring.test.springboot.service;

import com.spring.test.springboot.domain.User;
import com.spring.test.springboot.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo usersRepo;

    @Override
    public User findByLogin(String login){
        return usersRepo.findByLogin(login);
    }

    @Override
    public void addUser (User user) {
        usersRepo.save(user);
    }
}
