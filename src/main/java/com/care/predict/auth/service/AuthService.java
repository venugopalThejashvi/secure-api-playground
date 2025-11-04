package com.care.predict.auth.service;

import com.care.predict.auth.request.LoginRequest;
import com.care.predict.users.request.UserRequest;

public interface AuthService {
    String registerUser(UserRequest request);

    String loginUser(LoginRequest request);
}
