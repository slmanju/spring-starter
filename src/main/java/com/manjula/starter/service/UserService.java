package com.manjula.starter.service;

import com.manjula.starter.dto.PasswordDto;
import com.manjula.starter.dto.UserDto;

import java.util.List;

/**
 * @author Manjula Jayawardana
 */
public interface UserService {

    List<UserDto> findAll();

    UserDto findById(Long id);

    UserDto findByUsername(String username);

    void save(UserDto userDto);

    void update(UserDto userDto);

    void updatePassword(PasswordDto passwordDto);

    void updateLastLogin(String username);

    void delete(Long id);
}
