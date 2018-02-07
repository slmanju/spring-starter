package com.manjula.starter.repository;

import com.manjula.starter.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Manjula Jayawardana
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findById(Long id);

    @Query("SELECT role FROM Role role")
    Optional<List<Role>> findAllRoles();

}
