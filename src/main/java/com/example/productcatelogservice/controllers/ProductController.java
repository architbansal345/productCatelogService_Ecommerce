package com.example.productcatelogservice.controllers;

import com.example.productcatelogservice.dtos.CategoryDTO;
import com.example.productcatelogservice.dtos.ProductDTO;
import com.example.productcatelogservice.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/products/{id}")
    private ProductDTO getProductDetailsById(@PathVariable Long id){
        ProductDTO productDto = new  ProductDTO();
        productDto.setId(id);
        productDto.setDescription("Archit");
        CategoryDTO categoryDto = new  CategoryDTO();
        categoryDto.setDescription("category");
        categoryDto.setId(id);
        categoryDto.setName("category_name");
        productDto.setCategory(categoryDto);
        return productDto;
    }

    @GetMapping("/products/{pid}/{cid}")
    private ProductDTO getProductDetailsByPIDandCID(@PathVariable Long pid , @PathVariable Long cid){
        return null;
    }
}
