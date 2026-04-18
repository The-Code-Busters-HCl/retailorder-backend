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

    public CartItem addToCart(CartItem item) {
        return cartRepo.save(item);
    }

    public List<CartItem> getUserCart(Long userId) {
        return cartRepo.findByUserId(userId);
    }
}
