package org.codebusters.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import org.codebusters.demo.model.Order;
import org.codebusters.demo.model.Product;
import org.codebusters.demo.model.User;
import org.codebusters.demo.dto.OrderRequest;
import org.codebusters.demo.dto.OrderItem;
import org.codebusters.demo.repository.OrderRepository;
import org.codebusters.demo.repository.UserRepository;
import org.codebusters.demo.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepo;
    private final UserRepository userRepo;
    private final ProductRepository productRepo;

    public Order placeOrderFromRequest(String email, OrderRequest request) {

        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        double total = 0;

        for (OrderItem item : request.products()) {

            Product product = productRepo.findById(item.productId())
                    .orElseThrow(() -> new RuntimeException(
                            "Product not found: " + item.productId()
                    ));

            int qty = item.quantity();

            // ✅ stock check
            if (product.getStock() < qty) {
                throw new RuntimeException("Not enough stock for " + product.getName());
            }

            // ✅ real price
            total += product.getPrice() * qty;

            // ✅ reduce stock
            product.setStock(product.getStock() - qty);
            productRepo.save(product);
        }

        Order order = new Order();
        order.setUser(user);
        order.setTotalAmount(total);
        order.setStatus("PLACED");

        return orderRepo.save(order);
    }
}