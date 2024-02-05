package com.ancientjapaneseartexhibition.controller;

import com.ancientjapaneseartexhibition.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/images")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping
    public ResponseEntity<?> getAllImages() {

        return new ResponseEntity<>(
                imageService.getAllImage(),
                HttpStatus.OK
        );
    }
}