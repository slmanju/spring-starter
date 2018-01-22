package com.manjula.starter.validator;

import com.manjula.starter.dto.PasswordDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author Manjula Jayawardana
 */
@Component
public class PasswordValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return PasswordDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PasswordDto passwordDto = (PasswordDto) target;
        if (!passwordDto.getPassword().equals(passwordDto.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "password.mismatch", "Confirm password is not matching to password");
        }
    }

}
