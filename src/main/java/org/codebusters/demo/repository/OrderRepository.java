package org.codebusters.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.codebusters.demo.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}