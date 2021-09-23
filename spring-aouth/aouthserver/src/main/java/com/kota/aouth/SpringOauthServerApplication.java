package com.kota.aouth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringOauthServerApplication {
    public static void main(String[] args) {
        System.out.println("Application staring ");
        SpringApplication.run(SpringOauthServerApplication.class, args);
    }
}
