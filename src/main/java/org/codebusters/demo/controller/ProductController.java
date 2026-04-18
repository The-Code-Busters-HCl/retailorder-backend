package org.codebusters.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
    @GetMapping("/")
    public String getAllProducts() {
        return new String();
    }

    @GetMapping("/{id}")
    public String getProdById(@PathVariable Long param) {
        return new String();
    }
    

    @PostMapping("/add")
    public String postMethodName(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }
    
    @PutMapping("/update/{id}")
    public String putMethodName(@PathVariable Long id, @RequestBody String entity) {
        //TODO: process PUT request

        return entity;
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        return "";
    }

    
    
}
