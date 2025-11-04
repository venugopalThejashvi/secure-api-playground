package com.care.predict.users.service;

import com.care.predict.users.entity.Users;
import com.care.predict.users.repo.UserRepo;
import com.care.predict.users.request.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String saveUser(UserRequest request){
        if (userRepo.findByUsername(request.getUsername()).isPresent()){
            throw new RuntimeException("User Already Exists");
        }
        Users users = new Users();
        users.setUsername(request.getUsername());
        users.setPassword(passwordEncoder.encode(request.getPassword()));
        users.setRole(request.getRole());
        userRepo.save(users);
        return "User created Successfully";
    }
}
