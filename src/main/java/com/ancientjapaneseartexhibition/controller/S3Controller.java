package com.ancientjapaneseartexhibition.controller;

import com.ancientjapaneseartexhibition.s3.S3Service;
import com.ancientjapaneseartexhibition.util.S3BucketName;
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

    private final S3Service s3Service;

    public S3Controller(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    /**
     * @param file MultipartFile representing the image to be loaded.
     * @return ResponseEntity with the result of the upload.
     * */

    @PostMapping(
            value = "/",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity<?> uploadImageIntoS3PopUp(
            @RequestParam("image") MultipartFile file) {

        return new ResponseEntity<>(
                s3Service.putObject(S3BucketName.BUCKET_NAME, );
        );
    }

}
