package com.manjula.starter.repository;

import com.manjula.starter.model.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Manjula Jayawardana
 */
@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermission, Long> {

    Optional<RolePermission> findById(Long id);

    @Query("SELECT rp FROM RolePermission rp")
    Optional<List<RolePermission>> findAllRolePermissions();

    void deleteByRoleId(Long roleId);

}
