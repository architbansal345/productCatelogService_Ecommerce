package com.example.productcatelogservice.repository;

import com.example.productcatelogservice.models.Category;
import com.example.productcatelogservice.models.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class CategoryRepoTest {
    @Autowired
    private CategoryRepo categoryRepo;

    @Test
    @Transactional
    public void testFetchType(){
        Optional<Category> categoryOptional = categoryRepo.findById(1L);
        Category category = categoryOptional.get();
//        for(Product product : category.getProducts()){
//            System.out.println(product.getName());
//        }
    }
}