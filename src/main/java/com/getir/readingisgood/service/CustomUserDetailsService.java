package com.getir.readingisgood.service;

import com.getir.readingisgood.exception.ErrorCodes;
import com.getir.readingisgood.exception.GlobalApiException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @Author Eyup Erhan KARAASLAN - eyuperhankaraaslan94@gmail.com
 * @Version 1.0
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    public static final String USER = "getir";
    public static final String PASSWORD = "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6";

    @Override
    public UserDetails loadUserByUsername(String username) {
        if (USER.equals(username)) {
            return new User(USER, PASSWORD,
                    new ArrayList<>());
        } else {
            throw new GlobalApiException(ErrorCodes.USER_NOT_FOUND);
        }
    }
}