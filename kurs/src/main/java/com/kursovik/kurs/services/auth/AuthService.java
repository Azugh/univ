package com.kursovik.kurs.services.auth;

import com.kursovik.kurs.dto.SignupRequest;
import com.kursovik.kurs.dto.UserDTO;

public interface AuthService {

    UserDTO createCustomer(SignupRequest signupRequest);

    boolean hasCustomerWithEmail(String email);
}
