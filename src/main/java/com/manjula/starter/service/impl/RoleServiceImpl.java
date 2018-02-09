package com.manjula.starter.service.impl;

import com.manjula.starter.dto.PermissionDto;
import com.manjula.starter.dto.PolicyDto;
import com.manjula.starter.dto.RoleDto;
import com.manjula.starter.dto.RolePermissionDto;
import com.manjula.starter.model.Permission;
import com.manjula.starter.model.Role;
import com.manjula.starter.model.RolePermission;
import com.manjula.starter.repository.PermissionRepository;
import com.manjula.starter.repository.RolePermissionRepository;
import com.manjula.starter.repository.RoleRepository;
import com.manjula.starter.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

/**
 * @author Manjula Jayawardana
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;
    private PermissionRepository permissionRepository;
    private RolePermissionRepository rolePermissionRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository,
                           PermissionRepository permissionRepository,
                           RolePermissionRepository rolePermissionRepository) {
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
        this.rolePermissionRepository = rolePermissionRepository;
    }

    @Override
    public List<RoleDto> findAll() {
        Optional<List<Role>> allRoles = roleRepository.findAllRoles();
        return allRoles.map(roles -> roles.stream().map(Role::dto).collect(toList())).orElse(emptyList());
    }

    @Override
    public RoleDto findById(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        return role.map(Role::dto).orElse(null);
    }

    @Override
    public void save(RoleDto roleDto) {
        roleRepository.save(Role.valueOf(roleDto));
    }

    @Override
    public void update(RoleDto roleDto) {
        roleRepository.save(Role.valueOf(roleDto));
    }

    @Override
    public List<PermissionDto> findAllPermissions() {
        Optional<List<Permission>> allPermissions = permissionRepository.findAllPermissions();
        return allPermissions.map(permissions -> permissions.stream().map(Permission::dto).collect(toList())).orElse(emptyList());
    }

    @Override
    public void savePermissions(RolePermissionDto rolePermissionDto) {
        rolePermissionRepository.deleteByRoleId(rolePermissionDto.getRoleId());
        Role role = roleRepository.findOne(rolePermissionDto.getRoleId());
        PolicyDto[] policyDtos = rolePermissionDto.getPolicyDtos();
        List<RolePermission> rolePermissions = Arrays.stream(policyDtos).map(policyDto -> {
            RolePermission rolePermission = null;
            if (policyDto.isSelected()) {
                rolePermission = new RolePermission();
                rolePermission.setRole(role);
                rolePermission.setPermission(permissionRepository.findOne(policyDto.getPermissionId()));
                rolePermission.setPolicies(policyDto.policyTypes());
            }
            return rolePermission;
        }).filter(Objects::nonNull).collect(toList());
        rolePermissionRepository.save(rolePermissions);
    }

}
