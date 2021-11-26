package com.indieplay.mainWebService.controller;

import com.indieplay.mainWebService.dto.SignInRequest;
import com.indieplay.mainWebService.dto.SignUpRequest;
import com.indieplay.mainWebService.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
@AllArgsConstructor
public class RegistrationController {
    private final AuthenticationService authenticationService;

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(SignUpRequest request, Map<String, Object> model) {
        authenticationService.signup(request);
        return "redirect:/login";
    }

    @PostMapping("/signin")
    public String signin(SignInRequest request, Map<String, Object> model) {
        authenticationService.signin(request);

        return "sample success";
    }
}
