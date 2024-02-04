package com.example.examentw.Service;

import com.example.examentw.Entity.UserEntity;
import com.example.examentw.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserEntity getUserByUsernameAndPassword(String username, String password)
    {
        return this.userRepository.findUserEntityByUsernameAndPassword(username,password);
    }
    public UserEntity getUserByUsername(String username)
    {
        return this.userRepository.findUserEntityByUsername(username);
    }
}
