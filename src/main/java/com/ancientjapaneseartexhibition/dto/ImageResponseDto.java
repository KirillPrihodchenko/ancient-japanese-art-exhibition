package com.ancientjapaneseartexhibition.dto;

import jakarta.validation.constraints.NotEmpty;

public class ImageResponseDto {

    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
}