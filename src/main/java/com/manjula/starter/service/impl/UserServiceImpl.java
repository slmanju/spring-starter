package com.manjula.starter.service.impl;

import com.manjula.starter.dto.PasswordDto;
import com.manjula.starter.dto.UserDto;
import com.manjula.starter.model.User;
import com.manjula.starter.repository.UserRepository;
import com.manjula.starter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

/**
 * @author Manjula Jayawardana
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserDto> findAll() {
        Optional<List<User>> allUsers = userRepository.findAllUsers();
        return allUsers.map(users -> users.stream().map(User::dto).collect(toList())).orElse(emptyList());
    }

    @Override
    public UserDto findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(User::dto).orElse(null);
    }

    @Override
    public UserDto findByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(User::dto).orElse(null);
    }

    @Override
    public void save(UserDto userDto) {
        setEncodedPassword(userDto, userDto.getPassword());
        userRepository.save(User.valueOf(userDto));
    }

    @Override
    public void update(UserDto userDto) {
        userRepository.save(User.valueOf(userDto));
    }

    @Override
    public void updatePassword(PasswordDto passwordDto) {
        UserDto userDto = findById(passwordDto.getUserId());
        setEncodedPassword(userDto, passwordDto.getPassword());
        update(userDto);
    }

    private void setEncodedPassword(UserDto userDto, String password) {
        userDto.setPassword(passwordEncoder.encode(password));
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }

}
