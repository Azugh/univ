package com.kursovik.kurs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kursovik.kurs.dto.SignupRequest;
import com.kursovik.kurs.dto.UserDTO;
import com.kursovik.kurs.services.auth.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")    
    public ResponseEntity<?> signupCustomer(@RequestBody SignupRequest signupRequest) {

        UserDTO createdCustomererDTO = authService.createCustomer(signupRequest);
        if(createdCustomererDTO == null) return new ResponseEntity<>(
            "Пользователь не был создан. Повторите попытку", HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(createdCustomererDTO, HttpStatus.CREATED);
    }
}
