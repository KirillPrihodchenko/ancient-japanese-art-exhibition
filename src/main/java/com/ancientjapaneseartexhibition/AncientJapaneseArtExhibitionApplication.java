package com.ancientjapaneseartexhibition;

import com.ancientjapaneseartexhibition.s3.S3Service;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;

@SpringBootApplication
public class AncientJapaneseArtExhibitionApplication {

    public static void main(String[] args) {
        SpringApplication.run(AncientJapaneseArtExhibitionApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(S3Service s3Service) {

        return smth -> {
            //doFakeExample(s3Service);
        };
    }

//    private static void doFakeExample(S3Service s3Service) {
//        s3Service.putObject(
//                "acient-japanese-exhibition",
//                "japan",
//                new File("\\ancient-japanese-art-exhibition\\file")
//
//        );
//
//        byte[] object = s3Service.getObject(
//                "acient-japanese-exhibition",
//                "japan"
//        );
//
//        System.out.println("File has uploaded successfully!");
//    }
}