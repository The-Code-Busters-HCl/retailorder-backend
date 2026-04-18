package org.codebusters.demo.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

import org.codebusters.demo.model.Order;
import org.codebusters.demo.model.CartItem;
import org.codebusters.demo.model.User;

import org.codebusters.demo.repository.OrderRepository;
import org.codebusters.demo.repository.CartRepository;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepo;
    private final CartRepository cartRepo;

    public Order placeOrder(Long userId) {

        List<CartItem> items = cartRepo.findByUserId(userId);

        double total = items.stream()
                .mapToDouble(i -> i.getQuantity() * 100) // simplified
                .sum();

        Order order = new Order();


        User user = new User();
        user.setId(userId);

        order.setUser(user);
        order.setTotalAmount(total);
        order.setStatus("PLACED");

        cartRepo.deleteAll(items);

        return orderRepo.save(order);
    }
}