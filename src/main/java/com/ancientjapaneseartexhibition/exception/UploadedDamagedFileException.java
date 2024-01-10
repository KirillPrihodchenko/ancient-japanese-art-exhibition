package com.ancientjapaneseartexhibition.exception;

public class UploadedDamagedFileException extends RuntimeException {

     public UploadedDamagedFileException(String message) {
        super(message);
    }
}