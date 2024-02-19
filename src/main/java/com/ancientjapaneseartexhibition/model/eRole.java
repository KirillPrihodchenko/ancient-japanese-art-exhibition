package com.ancientjapaneseartexhibition.model;

public enum eRole {

    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_DEV("ROLE_DEVELOPER"),
    ROLE_USER("ROLE_USER");

    private String roleProperty;

    eRole(String roleProperty) {
        this.roleProperty = roleProperty;
    }

    public String extractRoleProperty() {
        return this.roleProperty;
    }
}