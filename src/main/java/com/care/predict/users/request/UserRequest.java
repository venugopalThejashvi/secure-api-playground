package com.care.predict.users.request;

import com.care.predict.validator.username.EmailCheck;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    @EmailCheck
    private String username;
    private String password;
    private String role;
}
