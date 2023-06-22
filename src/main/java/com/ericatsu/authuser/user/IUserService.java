package com.ericatsu.authuser.user;

import java.util.List;
import java.util.Optional;

import com.ericatsu.authuser.registration.RegistrationRequest;


public interface IUserService {
    List<User> getUser();
    User registerUser(RegistrationRequest request);
    Optional<User> findByEmail(String email);
}
