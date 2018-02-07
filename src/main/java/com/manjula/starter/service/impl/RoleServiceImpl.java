package com.manjula.starter.service.impl;

import com.manjula.starter.dto.RoleDto;
import com.manjula.starter.model.Role;
import com.manjula.starter.repository.RoleRepository;
import com.manjula.starter.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
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

}
