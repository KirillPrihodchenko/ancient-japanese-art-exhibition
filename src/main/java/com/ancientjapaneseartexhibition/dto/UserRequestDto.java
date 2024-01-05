package com.ancientjapaneseartexhibition.dto;

import com.ancientjapaneseartexhibition.model.Role;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UserRequestDto {

    @NotEmpty
    private String fullUsername;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
    @NotNull
    private Role role;

    public String getFullUsername() {
        return fullUsername;
    }

    public void setFullUsername(String fullUsername) {
        this.fullUsername = fullUsername;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}