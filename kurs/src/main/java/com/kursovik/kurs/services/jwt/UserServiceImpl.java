package com.kursovik.kurs.services.jwt;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kursovik.kurs.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsService() {
        return (String username) -> userRepository.findFirstByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
        
    }

}
