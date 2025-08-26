package com.learning.spring_security.constant;

import java.util.Set;

public enum Role {
    ADMIN(Set.of(Permission.READ,Permission.WRITE,Permission.DELETE)),
    USER(Set.of(Permission.READ));

    public final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}
