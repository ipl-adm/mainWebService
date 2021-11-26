package com.indieplay.mainWebService.service;

import com.indieplay.mainWebService.domain.entity.User;
import com.indieplay.mainWebService.dto.SignInRequest;
import com.indieplay.mainWebService.dto.SignUpRequest;

public interface AuthenticationService {
    void signup(SignUpRequest request);

    User signin(SignInRequest request);
}
