package com.example.productcatelogservice.repository;

import com.example.productcatelogservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {

}
