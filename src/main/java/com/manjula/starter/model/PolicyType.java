package com.manjula.starter.model;

/**
 * @author Manjula Jayawardana
 */
public enum PolicyType {

    CREATE, VIEW, DELETE;

    public static PolicyType from(String value) {
        if ("CREATE".equals(value)) {
            return PolicyType.CREATE;
        } else if ("VIEW".equals(value)) {
            return PolicyType.VIEW;
        } else if ("DELETE".equals(value)) {
            return PolicyType.DELETE;
        }
        return null;
    }

}
