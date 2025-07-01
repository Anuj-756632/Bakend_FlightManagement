package com.auth_service.repository;

import com.auth_service.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserData, Integer> {
    Optional<UserData> findByEmail(String email);
    Optional<UserData> findByUsername(String username);
}