package com.ericatsu.authuser.event.listener;

import java.util.UUID;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.ericatsu.authuser.event.RegistrationCompleteEvent;
import com.ericatsu.authuser.user.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class RegistrationCompleteListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // 1. Get the newly registered user
        User theUser = event.getUser();
        // 2. Create verification token for user;
        String verificationToken = UUID.randomUUID().toString();
        // 3. Save token for user
        // 4. Verication url to be sent to the user;
        String url = event.getApplicationUrl()+"/register/verifyEmail?token="+verificationToken;
        // 5. Send the email
        log.info("Click the link to complete the registration: {}", url);
    }
    
}
