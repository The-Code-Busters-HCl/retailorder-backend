package org.codebusters.demo.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

import org.codebusters.demo.model.CartItem;
import org.codebusters.demo.repository.CartRepository;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepo;

    // Add item to cart
    public CartItem addToCart(CartItem item) {
        return cartRepo.save(item);
    }

    // Get cart items by userId
    public List<CartItem> getUserCart(Long userId) {
        return cartRepo.findByUserId(userId);
    }

    // Remove single item from cart
    public void deleteItem(Long id) {
        cartRepo.deleteById(id);
    }

    //  Update cart item (quantity change)
    public CartItem updateCart(CartItem item) {
        return cartRepo.save(item); // update if ID exists
    }

    // Clear entire cart for a user
    public void clearCart(Long userId) {
        List<CartItem> items = cartRepo.findByUserId(userId);
        cartRepo.deleteAll(items);
    }
}