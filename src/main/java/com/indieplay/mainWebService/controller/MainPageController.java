package com.indieplay.mainWebService.controller;

import com.indieplay.mainWebService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping(value = {"/"})
@CrossOrigin(origins = "*")
public class MainPageController {

    @Autowired
    private UserRepository userRepository;

    public MainPageController() {
    }

    @GetMapping("/")
    public String defaultMethod(Map<String, Object> model) {
        System.out.println("index.ftlh");
        return "index";
    }
}
