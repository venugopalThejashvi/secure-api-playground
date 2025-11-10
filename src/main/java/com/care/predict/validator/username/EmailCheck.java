package com.care.predict.validator.username;


import com.care.predict.validator.message.Message;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@NotBlank(message = Message.invalidUserName)
@Documented
@Constraint(validatedBy = EmailCheckValidator.class)
public @interface EmailCheck {
    String message() default Message.invalidUserName;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
