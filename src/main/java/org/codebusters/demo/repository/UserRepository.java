package org.codebusters.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import org.codebusters.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
