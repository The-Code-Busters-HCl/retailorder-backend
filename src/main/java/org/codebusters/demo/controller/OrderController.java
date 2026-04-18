package org.codebusters.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import org.codebusters.demo.model.Order;
import org.codebusters.demo.dto.OrderRequest;
import org.codebusters.demo.service.OrderService;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/place")
    public Order placeOrder(@RequestBody OrderRequest request,
                            Authentication authentication) {

        String email = authentication.getName(); // ✅ this is enough

        return orderService.placeOrderFromRequest(email, request);
    }
}