package com.example.productcatelogservice.repository;

import com.example.productcatelogservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product,Long> {

}
