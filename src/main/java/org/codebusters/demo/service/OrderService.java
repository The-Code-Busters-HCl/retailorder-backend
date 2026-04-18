package org.codebusters.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import org.codebusters.demo.model.Order;
import org.codebusters.demo.model.User;
import org.codebusters.demo.dto.OrderRequest;
import org.codebusters.demo.repository.OrderRepository;
import org.codebusters.demo.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepo;
    private final UserRepository userRepo;


    public Order placeOrderFromRequest(String email, OrderRequest request) {


        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));


        double total = 0;

        List<Long> productIds = request.productIds();
        List<Integer> quantities = request.quantities();


        if (productIds.size() != quantities.size()) {
            throw new RuntimeException("Invalid request: size mismatch");
        }

        for (int i = 0; i < productIds.size(); i++) {
            int qty = quantities.get(i);

            // 👉 later replace with real product price
            total += qty * 100;
        }

        // 📦 Create order
        Order order = new Order();
        order.setUser(user);
        order.setTotalAmount(total);
        order.setStatus("PLACED");

        return orderRepo.save(order);
    }
}