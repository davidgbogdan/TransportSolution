package com.david.drxtransportsolution.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationRespose> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationRespose> authenticate(@RequestBody AuthenticationRequest request) throws AuthenticationException {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/register/admin")
    public ResponseEntity<AuthenticationRespose> registerAdmin(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(service.registerAdmin(request));
    }
}
