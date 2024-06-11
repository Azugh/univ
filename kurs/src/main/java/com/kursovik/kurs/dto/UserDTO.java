package com.kursovik.kurs.dto;

import com.kursovik.kurs.enums.UserRole;

import lombok.Data;

@Data
public class UserDTO {

    private long id;
    private String name;
    private String email;
    private UserRole userRole;
}
