package com.demo.business.objects.domain;

public enum UserStatus {
    ACTIVE,
    DELETED;

    public static UserStatus fromValue(String value) {
        try {
            return valueOf(value);
        } catch (RuntimeException ex) {
            throw new IllegalArgumentException("value does not exist", ex);
        }
    }

}
