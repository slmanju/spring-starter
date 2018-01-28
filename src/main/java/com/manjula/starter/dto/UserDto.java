package com.manjula.starter.dto;

import com.manjula.starter.model.UserRole;
import com.manjula.starter.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @author Manjula Jayawardana
 */
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class UserDto {

    private Long id;
    @NotEmpty(message = "{user.firstname.required}")
    private String firstName;
    @NotEmpty(message = "{user.lastname.required}")
    private String lastName;
    @NotEmpty(message = "{user.username.required}")
    @Length(min = 5, message = "{user.username.length}")
    private String username;
    @NotEmpty(message = "{password.required}")
    private String password;
    private Date lastLogin;
    private UserRole userRole;

}
