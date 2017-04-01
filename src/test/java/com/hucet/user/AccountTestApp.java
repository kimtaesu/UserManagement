package com.hucet.user;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class AccountTestApp {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(AccountTestApp.class);
        app.setAdditionalProfiles("test");
        app.run(args);
    }
}
