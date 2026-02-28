package com.system.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class healthcheck {

    @GetMapping("/system-check")
    public String healthcheck() {
        return "ok success";
    }
}
