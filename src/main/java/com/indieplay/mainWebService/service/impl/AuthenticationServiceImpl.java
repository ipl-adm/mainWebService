package com.indieplay.mainWebService.service.impl;

import com.indieplay.mainWebService.domain.entity.Role;
import com.indieplay.mainWebService.domain.entity.User;
import com.indieplay.mainWebService.dto.SignInRequest;
import com.indieplay.mainWebService.dto.SignUpRequest;
import com.indieplay.mainWebService.exception.AlreadyExistsException;
import com.indieplay.mainWebService.exception.AuthenticationException;
import com.indieplay.mainWebService.exception.NotFoundException;
import com.indieplay.mainWebService.mapper.UserMapper;
import com.indieplay.mainWebService.service.AuthenticationService;
import com.indieplay.mainWebService.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;

@Service
@AllArgsConstructor
class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final UserMapper userMapper;

    @Override
    public void signUp(SignUpRequest request) {
        if (userService.existsByUsername(request.getUsername())) throw new AlreadyExistsException(User.class);

        User user = userMapper.toEntity(request);

        user.setRoles(Collections.singleton(Role.USER));
        user.setRegisteredAt(LocalDateTime.now());
        user.setBalance(BigDecimal.ZERO);

        userService.save(user);
    }

    @Override
    public User signIn(SignInRequest request) {
        if (!userService.existsByUsername(request.getUsername())) throw new NotFoundException(User.class);
        User user = userService.get(request.getUsername());

        if (user.getPassword().equals(request.getPassword())) {
            return user;
        }

        throw new AuthenticationException();
    }
}
