package com.manjula.starter.model;

import com.manjula.starter.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Manjula Jayawardana
 */
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Table(name = "tbl_user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Date lastLogin;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    public UserDto dto() {
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(this, dto);
        return dto;
    }

    public static User valueOf(UserDto dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        return user;
    }

}
