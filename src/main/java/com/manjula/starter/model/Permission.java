package com.manjula.starter.model;

import com.manjula.starter.dto.PermissionDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Manjula Jayawardana
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String name;
    private String description;

    public PermissionDto dto() {
        PermissionDto dto = new PermissionDto();
        BeanUtils.copyProperties(this, dto);
        return dto;
    }
//
//    public static Permission valueOf(PrivilegeDto privilegeDto) {
//        Permission privilege = new Permission();
//        BeanUtils.copyProperties(privilegeDto, privilege);
//        return privilege;
//    }
//
//    public static List<PrivilegeDto> dtos(List<Permission> privileges) {
//        List<PrivilegeDto> privilegeViews = new ArrayList<>();
//        for (Permission privilege : privileges) {
//            privilegeViews.add(privilege.dto());
//        }
//        return privilegeViews;
//    }
//
//    public PrivilegeDto dto() {
//        PrivilegeDto privilegeDto = new PrivilegeDto();
//        BeanUtils.copyProperties(this, privilegeDto);
//        return privilegeDto;
//    }
//
}
