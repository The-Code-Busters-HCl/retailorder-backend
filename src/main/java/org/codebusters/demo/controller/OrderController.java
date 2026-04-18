package org.codebusters.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import org.codebusters.demo.model.Order;
import org.codebusters.demo.dto.OrderRequest;
import org.codebusters.demo.service.OrderService;
import org.codebusters.demo.service.CustomUserDetailsService;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;


    @PostMapping("/place")
    public Order placeOrder(@RequestBody OrderRequest request,
                            Authentication authentication) {


        CustomUserDetailsService userDetails =
                (CustomUserDetailsService) authentication.getPrincipal();

        String email = authentication.getName();

        return orderService.placeOrderFromRequest(email, request);
    }
}