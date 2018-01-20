package com.manjula.starter.repository;

import com.manjula.starter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @author Manjula Jayawardana
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    @Query("SELECT user FROM User user")
    Optional<List<User>> findAllUsers();

    Optional<User> findByUsername(String username);

}
