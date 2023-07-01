package com.ericatsu.authuser.event.listener;

import org.springframework.context.ApplicationListener;

import com.ericatsu.authuser.event.RegistrationCompleteEvent;

public class RegistrationCompleteListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // 1. Get the newly registered user
        // 2. Create verification token for user;
        // 3. Save token
    }
    
}
