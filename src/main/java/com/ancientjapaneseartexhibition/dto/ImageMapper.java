package com.ancientjapaneseartexhibition.dto;

import com.ancientjapaneseartexhibition.model.Image;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ImageMapper {

    private final ModelMapper modelMapper;

    public ImageMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Image convertToEntity(ImageRequestDto imageRequestDto) {
        return modelMapper.map(imageRequestDto, Image.class);
    }
}