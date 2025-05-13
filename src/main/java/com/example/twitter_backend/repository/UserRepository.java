package com.example.twitter_backend.repository;

import com.example.twitter_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);

    // Yeni eklenen metodlar
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}