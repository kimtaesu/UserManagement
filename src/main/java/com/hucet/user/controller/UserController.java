package com.hucet.user.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("user")
public class UserController {

    @PutMapping("join")
    String join() {
        return "test";
    }
}
