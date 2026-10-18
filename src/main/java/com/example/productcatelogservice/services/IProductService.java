package com.example.productcatelogservice.services;

import com.example.productcatelogservice.dtos.ProductDTO;
import com.example.productcatelogservice.models.Product;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IProductService {
    Product getProductDetailsById(Long id);
    Product updateProductDetails(Long id ,  Product product);
    Product createProduct(Product product);
    void deleteProductById(Long id);
    List<Product> getAllProducts();
}
