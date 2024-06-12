package com.kursovik.kurs.dto;

import com.kursovik.kurs.enums.UserRole;

import lombok.Data;

@Data
public class AuthenticationResponse {

    private String jwt;
    private UserRole userRole;
    private Long userId;
}
