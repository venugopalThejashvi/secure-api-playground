package com.care.predict.auth.controller;

import com.care.predict.auth.request.LoginRequest;
import com.care.predict.auth.service.AuthService;
import com.care.predict.users.request.UserRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserRequest request){
        return ResponseEntity.ok().body(authService.registerUser(request));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest request){
        return ResponseEntity.ok().body(authService.loginUser(request));
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheckWithAuth(){
        return ResponseEntity.ok("Running Successfully");
    }

    @GetMapping("/auth/health")
    public ResponseEntity<String> healthCheckWithoutAuth(){
        return ResponseEntity.ok("Running Successfully");
    }
}
