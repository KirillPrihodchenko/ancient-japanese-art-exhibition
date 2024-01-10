package com.ancientjapaneseartexhibition.repository;

import com.ancientjapaneseartexhibition.model.Role;
import com.ancientjapaneseartexhibition.model.eRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {

    Role findRoleByRole(eRole eRole);
}