package com.manjula.starter.config.security;

import com.manjula.starter.config.security.UserPrinciple;
import com.manjula.starter.dto.UserDto;
import com.manjula.starter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Manjula Jayawardana
 */
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserDto userDto = userService.findByUsername(userName);
        if (userDto == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrinciple(userDto, getAuthorities(userDto));
    }

    private Set<GrantedAuthority> getAuthorities(UserDto userDto) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userDto.getUserType().name());
        authorities.add(grantedAuthority);
        return authorities;
    }

}
