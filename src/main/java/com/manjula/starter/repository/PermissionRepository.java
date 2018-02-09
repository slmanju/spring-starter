package com.manjula.starter.repository;

import com.manjula.starter.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Manjula Jayawardana
 */
@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

    Optional<Permission> findById(Long id);

    @Query("SELECT permission FROM Permission permission")
    Optional<List<Permission>> findAllPermissions();

}
