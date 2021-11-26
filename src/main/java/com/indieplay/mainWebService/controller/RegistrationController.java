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

    @GetMapping("/signUp")
    public String signUp() {
        return "signUp";
    }

    @GetMapping("/signIn")
    public String signIn() {
        return "signIn";
    }

    @PostMapping("/signUp")
    public String signUp(SignUpRequest request, Map<String, Object> model) {
        authenticationService.signUp(request);
        return "redirect:/signUp";
    }

    @PostMapping("/signIn")
    public String signIn(SignInRequest request, Map<String, Object> model) {
        authenticationService.signIn(request);

        return "index";
    }
}
