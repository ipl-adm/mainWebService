package com.indieplay.mainWebService.controller;

import com.indieplay.mainWebService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

public class UserController {

    @Autowired
    private UserRepository userRepository;
}
