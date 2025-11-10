package com.care.predict.validator.username;

import com.care.predict.users.repo.UserRepo;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class EmailCheckValidator implements ConstraintValidator<EmailCheck, String> {
    private final UserRepo repo;
    @Override
    public boolean isValid(String username, ConstraintValidatorContext ctx) {
        String emailRegex = "^(?i)[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$";
        return username.matches(emailRegex);
    }
}
