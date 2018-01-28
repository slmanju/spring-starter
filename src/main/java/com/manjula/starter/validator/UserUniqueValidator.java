package com.manjula.starter.validator;

import com.manjula.starter.dto.UserDto;
import com.manjula.starter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author Manjula Jayawardana
 */
@Component
public class UserUniqueValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        Long id = userDto.getId();
        UserDto found = userService.findByUsername(userDto.getUsername());
        if (found != null && (id == null || !id.equals(found.getId()))) {
            errors.rejectValue("username", "username.already.exist", "User name already exist");
        }
    }

}
