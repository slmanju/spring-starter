package com.manjula.starter.service;

import java.util.List;

import com.manjula.starter.dto.PermissionDto;
import com.manjula.starter.dto.RoleDto;
import com.manjula.starter.dto.RolePermissionDto;

public interface RoleService {

    List<RoleDto> findAll();

	void save(RoleDto roleDto);

	RoleDto findById(Long id);

//	List<PrivilegeView> findAllPrivileges();
//
//	List<PrivilegeView> findPrivileges(List<String> privilegeIds);

    void update(RoleDto roleDto);

    // permission
    List<PermissionDto> findAllPermissions();

    void savePermissions(RolePermissionDto rolePermissionDto);

}
