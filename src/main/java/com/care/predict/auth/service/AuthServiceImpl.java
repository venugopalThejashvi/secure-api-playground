package com.care.predict.auth.service;


import com.care.predict.auth.request.LoginRequest;
import com.care.predict.users.repo.UserRepo;
import com.care.predict.users.request.UserRequest;
import com.care.predict.users.service.UserService;
import com.care.predict.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    @Override
    public String registerUser(UserRequest request){
        return userService.saveUser(request);
    }

    @Override
    public String loginUser(LoginRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword())
        );
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
       return jwtUtil.generateToken(userDetails);
    }
}
