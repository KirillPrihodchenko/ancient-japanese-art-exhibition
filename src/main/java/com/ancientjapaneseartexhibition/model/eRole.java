package com.ancientjapaneseartexhibition.model;

public enum eRole {

    ROLE_ADMIN("ADMIN"),
    ROLE_USER("USER");

    private String roleProperty;

    eRole(String roleProperty) {
        this.roleProperty = roleProperty;
    }

    public String extractRoleProperty() {
        return this.roleProperty;
    }
}