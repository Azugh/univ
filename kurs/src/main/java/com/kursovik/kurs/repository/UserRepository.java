package com.kursovik.kurs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kursovik.kurs.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

Optional<User> findFirstByEmail(String email);

}
