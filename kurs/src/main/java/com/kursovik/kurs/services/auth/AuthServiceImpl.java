package com.kursovik.kurs.services.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kursovik.kurs.dto.SignupRequest;
import com.kursovik.kurs.dto.UserDTO;
import com.kursovik.kurs.entity.User;
import com.kursovik.kurs.enums.UserRole;
import com.kursovik.kurs.repository.UserRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @PostConstruct
    public void createAdmin() {
        User admin = userRepository.findByUserRole(UserRole.ADMIN);
        if(admin == null) {
            User newAdmin = new User();
            newAdmin.setName("Admin");
            newAdmin.setEmail("Admin@test.com");
            newAdmin.setPassword(new BCryptPasswordEncoder().encode("admin"));
            newAdmin.setUserRole(UserRole.ADMIN); 
            userRepository.save(newAdmin);
            System.out.println("Админ создан");
        }
    }

    @Override
    public UserDTO createUser(SignupRequest signupRequest) {
        User user = new User();
        user.setName(signupRequest.getName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        user.setUserRole(UserRole.USER);
        User createdUser = userRepository.save(user);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(createdUser.getId());
        return userDTO;
    }

    @Override
    public boolean hasUserWithEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }

   
}
