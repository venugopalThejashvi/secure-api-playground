package com.care.predict.users.service;

import com.care.predict.exception.custom.UserAlreadyPresentException;
import com.care.predict.kafka.Topic;
import com.care.predict.users.entity.Users;
import com.care.predict.users.event.EmailEvent;
import com.care.predict.users.repo.UserRepo;
import com.care.predict.users.request.UserRequest;
import com.care.predict.validator.message.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final KafkaTemplate<String, EmailEvent> publisher;

    @Override
    public String saveUser(UserRequest request){
        String userName = request.getUsername().toLowerCase();
        if (userRepo.existsByUsername(userName)){
            throw new UserAlreadyPresentException(Message.uniqueUserName);
        }
        Users users = new Users();
        users.setUsername(userName);
        users.setPassword(passwordEncoder.encode(request.getPassword()));
        users.setRole(request.getRole());
        userRepo.save(users);
        int inputIndex = request.getUsername().indexOf("@");
        publisher.send(Topic.userRegistered,new EmailEvent(request.getUsername(),"REGISTRATION SUCCESSFUL","Hello "+userName.substring(0,inputIndex)+"\n\nYou have been Registered Successfully"));
        return "User created Successfully";
    }
}
