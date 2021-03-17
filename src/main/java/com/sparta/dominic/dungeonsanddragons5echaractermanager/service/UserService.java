package com.sparta.dominic.dungeonsanddragons5echaractermanager.service;

import com.sparta.dominic.dungeonsanddragons5echaractermanager.entity.UserEntity;
import com.sparta.dominic.dungeonsanddragons5echaractermanager.repository.UserRepository;
import com.sparta.dominic.dungeonsanddragons5echaractermanager.security.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity save(UserEntity user) {
        user.setRole("ROLE_USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
