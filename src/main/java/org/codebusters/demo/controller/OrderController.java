package org.codebusters.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/order")
public class OrderController {
    @GetMapping("/{uid}")
    public String getCartItems(@PathVariable Long uid) {
        return "";
    }

    @PostMapping("/add/")
    public String addItem(@RequestParam Long itmId, @RequestBody String path) {
        return "";
    }

    
}
