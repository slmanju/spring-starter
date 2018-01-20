package com.manjula.starter.config.security;

import java.util.Collection;

import com.manjula.starter.dto.UserDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * @author Manjula Jayawardana
 */
public class UserPrinciple extends User {
    
    private static final long serialVersionUID = 1L;
    
    private Long userId;
    private String firstName;
    private String lastName;

    public UserPrinciple(UserDto userDTO, Collection<GrantedAuthority> authorities) {
        super(userDTO.getUsername(), userDTO.getPassword(), authorities);
        this.userId = userDTO.getId();
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
