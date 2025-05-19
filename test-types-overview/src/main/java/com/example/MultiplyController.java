package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultiplyController {
    @Autowired
    private BusinessService businessService;

    @GetMapping("/multiply")
    public String multiply(@RequestParam("a") int a, @RequestParam("b") int b) {
        return String.valueOf(businessService.multiply(a, b));
    }
}
