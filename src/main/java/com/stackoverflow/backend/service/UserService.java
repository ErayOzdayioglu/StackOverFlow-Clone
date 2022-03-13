package com.stackoverflow.backend.service;

import com.stackoverflow.backend.data.entity.User;
import com.stackoverflow.backend.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public void addUser() {
        User user = new User();
        userRepository.save(user);
    }
}
