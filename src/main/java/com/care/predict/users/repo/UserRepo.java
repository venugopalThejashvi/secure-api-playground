package com.care.predict.users.repo;

import com.care.predict.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Users, Integer> {
    Optional<Users> findByUsername(String username);

    boolean existsByUsername(String username);
}
