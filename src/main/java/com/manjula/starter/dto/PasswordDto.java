package com.manjula.starter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * @author Manjula Jayawardana
 */
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class PasswordDto {

    private Long userId;
    @NotEmpty(message = "{password.required}")
    private String password;
    @NotEmpty(message = "{password.confirm.required}")
    private String confirmPassword;

}
