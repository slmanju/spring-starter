package com.manjula.starter.config.security;

import com.manjula.starter.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

/**
 * @author Manjula Jayawardana
 */
@Component
public class UserLoginListener {

    private static Logger LOGGER = LoggerFactory.getLogger(UserLoginListener.class);

    private UserService userService;

    public UserLoginListener(UserService userService) {
        this.userService = userService;
    }

    @EventListener
    public void handleUserLogin(InteractiveAuthenticationSuccessEvent event) {
        UserPrinciple user = (UserPrinciple) event.getAuthentication().getPrincipal();
        LOGGER.info("::: user {} logged in at {} :::", user.getUsername(), event.getTimestamp());
        userService.updateLastLogin(user.getUsername());
    }

}
