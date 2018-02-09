package com.manjula.starter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Manjula Jayawardana
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RolePermissionDto {

    private Long roleId;
    private PolicyDto[] policyDtos;

}
