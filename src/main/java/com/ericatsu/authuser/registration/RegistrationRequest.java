package com.ericatsu.authuser.registration;


public record RegistrationRequest( 
     String firstName,
     String lastname,
     String password,
     String email,
     String role) {}
