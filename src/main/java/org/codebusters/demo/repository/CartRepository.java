package org.codebusters.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import org.codebusters.demo.model.CartItem;

public interface CartRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUserId(Long userId);
}