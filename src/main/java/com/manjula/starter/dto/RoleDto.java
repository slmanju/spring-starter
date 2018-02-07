package com.manjula.starter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Manjula Jayawardana
 */
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class RoleDto {

    private Long id;
    private String name;
    private String code;
    private String description;

//    private List<PrivilegeDto> privilegeDtos = new ArrayList<>();
//    private List<String> privilegeIds = new ArrayList<>();
    
}
