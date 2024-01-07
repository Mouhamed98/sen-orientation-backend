package com.senorientation.backend.auth;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authService;
    

    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponse> register(
        @RequestBody() RegisterRequest registerRequest
    ) {
        return ResponseEntity.ok(authService.register(registerRequest));
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthenticationResponse> login(
        @RequestBody() AuthenticationRequest authRequest
    ) {
        return ResponseEntity.ok(authService.login(authRequest));
    }
    
}
