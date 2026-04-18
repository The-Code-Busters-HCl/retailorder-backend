package org.codebusters.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/order")
public class OrderController {
    @GetMapping("/cart/{uid}")
    public String getCartItems(@PathVariable Long uid) {
        return "";
    }

    @PostMapping("/add/{itmId}")
    public String addItem(@PathVariable Long itmId, @RequestBody String path) {
        return "";
    }
}
