package org.codebusters.demo.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

import org.codebusters.demo.model.Product;
import org.codebusters.demo.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repo;

    // Add product
    public Product addProduct(Product p) {
        return repo.save(p);
    }

    //  Get product by ID
    public Product getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    //  Get all products
    public List<Product> getAll() {
        return repo.findAll();
    }

    //  Update product
    public Product updateProduct(Long id, Product updatedProduct) {
        Product product = getById(id);

        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());
        product.setStock(updatedProduct.getStock());
        product.setCategory(updatedProduct.getCategory());

        return repo.save(product);
    }

    //  Delete product
    public void deleteProduct(Long id) {
        Product product = getById(id);
        repo.delete(product);
    }
}