package com.kursovik.kurs.services.auth;

import com.kursovik.kurs.dto.SignupRequest;
import com.kursovik.kurs.dto.UserDTO;

public interface AuthService {

    UserDTO createUser(SignupRequest signupRequest);

    boolean hasUserWithEmail(String email);
}
