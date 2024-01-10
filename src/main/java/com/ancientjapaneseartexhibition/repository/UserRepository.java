package com.ancientjapaneseartexhibition.repository;

import com.ancientjapaneseartexhibition.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findUserByEmail(String email);
    User updateUserByEmail(String email);
}
