package com.manjula.starter.dto;

import com.manjula.starter.model.PolicyType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Manjula Jayawardana
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PolicyDto {

    private Long permissionId;
    private String code;
    private boolean create;
    private boolean view;
    private boolean delete;

    public boolean isSelected() {
        return (create || view || delete);
    }

    public List<PolicyType> policyTypes() {
        List<PolicyType> policyTypes = new ArrayList<>();
        if (create) {
            policyTypes.add(PolicyType.CREATE);
        }
        if (view) {
            policyTypes.add(PolicyType.VIEW);
        }
        if (delete) {
            policyTypes.add(PolicyType.DELETE);
        }
        return policyTypes;
    }

}
