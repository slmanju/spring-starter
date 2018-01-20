package com.manjula.starter.dto;

import com.manjula.starter.model.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Manjula Jayawardana
 */
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private UserType userType;

}
