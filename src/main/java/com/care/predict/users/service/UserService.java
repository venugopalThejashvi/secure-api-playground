package com.care.predict.users.service;

import com.care.predict.users.entity.Users;
import com.care.predict.users.request.UserRequest;

import java.util.List;

public interface UserService {
    String saveUser(UserRequest request);
}
