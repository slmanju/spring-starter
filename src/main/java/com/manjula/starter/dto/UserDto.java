package com.manjula.starter.dto;

import com.manjula.starter.model.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

/**
 * @author Manjula Jayawardana
 */
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class UserDto {

    private Long id;
    @NotEmpty(message = "First name is required")
    private String firstName;
    @NotEmpty(message = "Last name is required")
    private String lastName;
    @NotEmpty(message = "User name is required")
    @Length(min = 5, message = "User name should be at least {min} characters long")
    private String username;
    @NotEmpty(message = "Password is required")
    private String password;
    private UserType userType;

}
