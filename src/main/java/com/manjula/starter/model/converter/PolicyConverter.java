package com.manjula.starter.model.converter;

import com.manjula.starter.model.PolicyType;

import javax.persistence.AttributeConverter;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author Manjula Jayawardana
 */
public class PolicyConverter implements AttributeConverter<List<PolicyType>, String> {

    private static final String SEPARATOR = ",";

    /**
     * Convert List<PolicyType> to a String with format CREATE|READ|DELETE
     */
    @Override
    public String convertToDatabaseColumn(List<PolicyType> policyTypes) {
        StringBuilder builder = new StringBuilder();
        policyTypes.forEach(policyType -> builder.append(policyType).append(SEPARATOR));
        builder.deleteCharAt(builder.lastIndexOf(SEPARATOR));
        return builder.toString();
    }

    /**
     * Convert a String with format CREATE|READ|DELETE to a List<PolicyType> object
     */
    @Override
    public List<PolicyType> convertToEntityAttribute(String entity) {
        String[] policies = entity.split(SEPARATOR);
        return Arrays.stream(policies).map(PolicyType::from).collect(toList());
    }

}
