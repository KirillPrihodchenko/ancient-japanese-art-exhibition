package com.ancientjapaneseartexhibition.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan (basePackages = {
        "com.ancientjapaneseartexhibition.model",
        "com.ancientjapaneseartexhibition.controller",
        "com.ancientjapaneseartexhibition.service"}
)
public class WebConfig {
}