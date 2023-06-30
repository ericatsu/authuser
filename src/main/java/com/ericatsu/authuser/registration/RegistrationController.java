package com.ericatsu.authuser.registration;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ericatsu.authuser.user.User;
import com.ericatsu.authuser.user.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegistrationController {

    private final UserService userService;

    @PostMapping
    public String registerUser(RegistrationRequest registrationRequest) {
        User user = userService.registerUser(registrationRequest);
        return "Success: Please check your email to complete registration";
    }
}
