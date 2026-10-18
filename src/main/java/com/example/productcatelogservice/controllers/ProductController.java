package com.example.productcatelogservice.controllers;

import com.example.productcatelogservice.dtos.CategoryDTO;
import com.example.productcatelogservice.dtos.ProductDTO;
import com.example.productcatelogservice.mapper.Mapper;
import com.example.productcatelogservice.models.Product;
import com.example.productcatelogservice.services.IProductService;
import com.example.productcatelogservice.services.ProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    @Qualifier("storageProductService")
    private IProductService productService;

    @Autowired
    private Mapper mapper;

    @GetMapping("/{id}")
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


    @PutMapping("/{id}")
    private ResponseEntity<ProductDTO> updateProducts(@PathVariable Long id , @RequestBody ProductDTO productDTO){
        Product input = mapper.from(productDTO);
        input.setId(id);
        Product output = productService.updateProductDetails(id,input);
        return new ResponseEntity<>(mapper.Pfrom(output),HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<ProductDTO> createProducts(@RequestBody ProductDTO productDTO){
        Product input = mapper.from(productDTO);
        Product output = productService.createProduct(input);
        return new ResponseEntity<>(mapper.Pfrom(output),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
        return new ResponseEntity<>(null,HttpStatus.OK);
    }
    @GetMapping
    private ResponseEntity<List<ProductDTO>> getProductDetailsById(){
        List<Product> products =  productService.getAllProducts();
        List<ProductDTO>res = new ArrayList<>();
        for(Product i : products){
            res.add(mapper.Pfrom(i));
        }
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
}
