package com.indieplay.mainWebService.controller;

import com.indieplay.mainWebService.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserController {

    @Autowired
    private UserRepository userRepository;
}
