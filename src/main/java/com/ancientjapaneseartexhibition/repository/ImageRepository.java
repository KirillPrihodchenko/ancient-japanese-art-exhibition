package com.ancientjapaneseartexhibition.repository;

import com.ancientjapaneseartexhibition.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ImageRepository extends JpaRepository<Image, UUID> {

    Optional<Image> findImageByName(String name);

    @Modifying
    @Query("UPDATE Image i SET i.name = :name, i.url = :url, i.description = :description WHERE i.name = :name")
    Image updateImageByName(String name, String url, String description);
}