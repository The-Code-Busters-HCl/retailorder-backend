package org.codebusters.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.codebusters.demo.model.CartItem;
import org.codebusters.demo.service.CartService;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

<<<<<<< HEAD
=======
    // Add item to cart
>>>>>>> 4a22e5e (Fixed /auth)
    @PostMapping("/add")
    public CartItem addToCart(@RequestBody CartItem item) {
        return cartService.addToCart(item);
    }

<<<<<<< HEAD
=======
    // Get user cart
>>>>>>> 4a22e5e (Fixed /auth)
    @GetMapping("/{userId}")
    public List<CartItem> getUserCart(@PathVariable Long userId) {
        return cartService.getUserCart(userId);
    }

<<<<<<< HEAD
=======
    //  Remove item from cart
>>>>>>> 4a22e5e (Fixed /auth)
    @DeleteMapping("/remove/{id}")
    public String removeItem(@PathVariable Long id) {
        cartService.deleteItem(id);
        return "Item removed from cart";
    }

    //  Update quantity
    @PutMapping("/update")
    public CartItem updateCart(@RequestBody CartItem item) {
        return cartService.updateCart(item);
    }

    // Clear cart
    @DeleteMapping("/clear/{userId}")
    public String clearCart(@PathVariable Long userId) {
        cartService.clearCart(userId);
        return "Cart cleared";
    }
}