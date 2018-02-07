package com.manjula.starter.service;

import java.util.List;

import com.manjula.starter.dto.RoleDto;

public interface RoleService {

    List<RoleDto> findAll();

	void save(RoleDto roleDto);

	RoleDto findById(Long id);

//	List<PrivilegeView> findAllPrivileges();
//
//	List<PrivilegeView> findPrivileges(List<String> privilegeIds);

    void update(RoleDto roleDto);

}
