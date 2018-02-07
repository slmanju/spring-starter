package com.manjula.starter.model;

import com.manjula.starter.dto.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Manjula Jayawardana
 */
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "tbl_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String name;
    private String description;
//    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
//    @JoinTable(name = "role_privilege",
//            joinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") },
//            inverseJoinColumns = { @JoinColumn(name = "privilege_id", referencedColumnName = "id") })
//    private List<Privilege> privileges = new ArrayList<>();

    public static Role valueOf(RoleDto roleDto) {
        Role role = new Role();
        BeanUtils.copyProperties(roleDto, role);
//        for (PrivilegeDto privilegeDto : roleDto.getPrivilegeDtos()) {
//            role.getPrivileges().add(Privilege.valueOf(privilegeDto));
//        }
        return role;
    }
    
    public static List<RoleDto> dtos(List<Role> roles) {
        return roles.stream().map(Role::dto).collect(Collectors.toList());
    }
    
    public RoleDto dto() {
        RoleDto roleDto = new RoleDto();
        BeanUtils.copyProperties(this, roleDto);
        return roleDto;
    }
    
}
