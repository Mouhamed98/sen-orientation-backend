package com.senorientation.backend.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.senorientation.backend.config.JwtService;
import com.senorientation.backend.exception.ApiRequestException;
import com.senorientation.backend.user.Role;
import com.senorientation.backend.user.User;
import com.senorientation.backend.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public Boolean checkDuplicatedUser(String email, String phoneNumber) {
        var userEmail = userRepository.findByEmail(email);
        var userPhone = userRepository.findByPhoneNumber(phoneNumber);
        return userEmail.isPresent() || userPhone.isPresent();
    }

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var userExists = checkDuplicatedUser(registerRequest.getEmail(), registerRequest.getPhoneNumber());
        if (userExists) {
            throw new ApiRequestException("User already exists");
        }
        var user = User.builder()
            .firstname(registerRequest.getFirstname())
            .lastname(registerRequest.getLastname())
            .email(registerRequest.getEmail())
            .phoneNumber(registerRequest.getPhoneNumber())
            .password(passwordEncoder.encode(registerRequest.getPassword()))
            .role(Role.STUDENT)
            .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
            .builder()
            .token(jwtToken)
            .build();
    }

    public AuthenticationResponse login(AuthenticationRequest authRequest) {
        System.out.println(authRequest);
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
        var user = userRepository.findByEmail(authRequest.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
            .builder()
            .token(jwtToken)
            .build();
    }

}
