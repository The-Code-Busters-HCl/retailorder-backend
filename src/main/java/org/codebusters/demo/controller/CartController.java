package org.codebusters.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.codebusters.demo.model.CartItem;
import org.codebusters.demo.service.CartService;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    // ✅ Add item to cart
    @PostMapping("/add")
    public CartItem addToCart(@RequestBody CartItem item) {
        return cartService.addToCart(item);
    }

    // ✅ Get user cart
    @GetMapping("/{userId}")
    public List<CartItem> getUserCart(@PathVariable Long userId) {
        return cartService.getUserCart(userId);
    }

    // ✅ Remove item from cart
    @DeleteMapping("/remove/{id}")
    public String removeItem(@PathVariable Long id) {
        cartService.deleteItem(id);
        return "Item removed from cart";
    }

    // ✅ Update quantity
    @PutMapping("/update")
    public CartItem updateCart(@RequestBody CartItem item) {
        return cartService.updateCart(item);
    }

    // ✅ Clear cart
    @DeleteMapping("/clear/{userId}")
    public String clearCart(@PathVariable Long userId) {
        cartService.clearCart(userId);
        return "Cart cleared";
    }
}