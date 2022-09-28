package com.shos.shos.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Arrays;
import java.util.Optional;

public enum Role {
    ROLE_ADMIN,
    ROLE_CLIENT;
	

    @JsonCreator
    public static Role setValue(String key) {
        return Arrays.stream(Role.values())
            .filter(role -> role.toString().equals(key.toUpperCase()))
            .findAny()
            .orElse(null);
    }
}
