package com.example.helloservice.controller;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/test")
@RestController
public class TestController {

    @GetMapping("/updateKaide")
    public Boolean updateKaide(String shopStr) {
        System.out.println(shopStr);
        return true;
    }
}
