package com.rifqimuhammadaziz.apimedicalrecordsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NothingController {

    @GetMapping("/nothing")
    public String testTemplate() {
        return "test-template";
    }
}
