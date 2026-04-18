package org.codebusters.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private double price;

    private int stock;

    private String category;
<<<<<<< HEAD
    @Column(nullable = false)
=======
>>>>>>> 4a22e5e (Fixed /auth)
    private String image;
}