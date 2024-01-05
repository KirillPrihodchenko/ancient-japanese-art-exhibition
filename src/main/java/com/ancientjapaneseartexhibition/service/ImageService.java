package com.ancientjapaneseartexhibition.service;

import com.ancientjapaneseartexhibition.dto.ImageMapper;
import com.ancientjapaneseartexhibition.dto.ImageRequestDto;
import com.ancientjapaneseartexhibition.model.Image;
import com.ancientjapaneseartexhibition.repository.ImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    private final ImageRepository imageRepository;
    private final ImageMapper imageMapper;

    public ImageService(ImageRepository imageRepository, ImageMapper imageMapper) {
        this.imageRepository = imageRepository;
        this.imageMapper = imageMapper;
    }

    public List<Image> getAllImage() {

        return imageRepository.findAll();
    }

    public Image addImage(ImageRequestDto imageRequestDto) {

        Image image = imageMapper.convertToEntity(imageRequestDto);
        return imageRepository.save(image);
    }

    /**
     * this method will be implemented on the frontend of the button layer
     * */
//    public void deleteById() {
//        System.out.println("image deleted successfully!");
//    }
}