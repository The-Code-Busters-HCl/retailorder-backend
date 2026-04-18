package org.codebusters.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.codebusters.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}