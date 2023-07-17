package com.ericatsu.authuser.registration;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ericatsu.authuser.event.RegistrationCompleteEvent;
import com.ericatsu.authuser.registration.token.VerificationToken;
import com.ericatsu.authuser.registration.token.VerificationTokenRepository;
import com.ericatsu.authuser.user.User;
import com.ericatsu.authuser.user.UserService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegistrationController {

    private final UserService userService;
    private final ApplicationEventPublisher publisher;
    private final VerificationTokenRepository tokenRepository;

    @PostMapping
    public String registerUser(@RequestBody RegistrationRequest registrationRequest, final HttpServletRequest request) {
        User user = userService.registerUser(registrationRequest);
        
        //Publish registration event 
        publisher.publishEvent(new RegistrationCompleteEvent(user, applicationUrl(request)));
        return "Success: Please check your email to complete registration";
    }

    // 2:21:20
    @GetMapping("/verifyEmail")
    public String verifyEmail(@RequestParam("token") String token){
       VerificationToken theToken = tokenRepository.findByToken(token);
       if (theToken.getUser().isEnabled()) {
        return "The account has already been verified, Please login";
       } 
       String verificationResult = userService.validateToken(token);
       if (verificationResult.equalsIgnoreCase("valid")) {
        return "Email verified successfully. Now you can login to your account";
       }
       return "Invalid verification token";
    }

    public String applicationUrl(HttpServletRequest request) {
        return "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
    }
}
