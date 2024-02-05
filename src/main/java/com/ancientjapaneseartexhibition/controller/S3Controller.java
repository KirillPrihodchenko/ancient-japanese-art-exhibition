package com.ancientjapaneseartexhibition.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Controller for uploading images to Amazon S3.
 * Will be modified and used exclusively ROLE_ADMIN.
 */

@RestController
@RequestMapping("/api/v1/uploads")
public class S3Controller {

    /**
     * @param file MultipartFile representing the image to be loaded.
     * @return ResponseEntity with the result of the upload.
     * */

    @PostMapping(
            value = "/",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity<?> uploadImageIntoS3(
            @RequestParam("image") MultipartFile file) {

        return new ResponseEntity<>(
        );
    }

}
