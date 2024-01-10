package com.ancientjapaneseartexhibition.service;

import com.ancientjapaneseartexhibition.model.Image;
import com.ancientjapaneseartexhibition.repository.ImageRepository;
import com.ancientjapaneseartexhibition.s3.S3Service;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    private final ImageRepository imageRepository;
    private final S3Service s3Service;

    public ImageService(ImageRepository imageRepository, S3Service s3Service) {
        this.imageRepository = imageRepository;
        this.s3Service = s3Service;
    }

    public List<Image> getAllImage() {

        return imageRepository.findAll();
    }

    public Image addImage(Image image, String bucketName, String key) {

        String imageUrl = s3Service.getUrlToObject(bucketName, key);

        Image newImage = new Image();
        newImage.setName(image.getName());
        newImage.setUrl(imageUrl);
        newImage.setDescription(image.getDescription());

        return imageRepository.save(image);
    }
}