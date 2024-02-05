package com.ancientjapaneseartexhibition.repository;

import com.ancientjapaneseartexhibition.model.Role;
import com.ancientjapaneseartexhibition.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findUserByEmail(String email);

    @Modifying
    @Query("UPDATE User u SET u.fullUsername = :fullUsername, u.email = :email, u.password = :password, u.role = :role WHERE u.email = :email")
    User updateUserByEmail(String fullUsername, String email, String password, Role role);
}