package com.example.productcatelogservice.controllers;

import com.example.productcatelogservice.dtos.CategoryDTO;
import com.example.productcatelogservice.dtos.ProductDTO;
import com.example.productcatelogservice.mapper.Mapper;
import com.example.productcatelogservice.models.Product;
import com.example.productcatelogservice.services.IProductService;
import com.example.productcatelogservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @Autowired
    private IProductService productService;

    @Autowired
    private Mapper mapper;

    @GetMapping("/products/{id}")
    private ResponseEntity<ProductDTO> getProductDetailsById(@PathVariable Long id){
        if(id < 0L){
            throw new IllegalArgumentException("Id cannot be -ve");
        }
        Product product =  productService.getProductDetailsById(id);
        if(product == null){
            throw new RuntimeException("Product not found");
        }
        return new ResponseEntity<>(mapper.Pfrom(product),HttpStatus.OK);
    }


    @PutMapping("/products/{id}")
    private ResponseEntity<ProductDTO> updateProducts(@PathVariable Long id , @RequestBody ProductDTO productDTO){
        Product input = mapper.from(productDTO);
        input.setId(id);
        Product output = productService.updateProductDetails(id,input);
        return new ResponseEntity<>(mapper.Pfrom(output),HttpStatus.OK);
    }
}
