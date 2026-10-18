package com.example.productcatelogservice.services;

import com.example.productcatelogservice.mapper.Mapper;
import com.example.productcatelogservice.models.Product;
import com.example.productcatelogservice.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class StorageProductService implements IProductService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private Mapper mapper;

    @Override
    public Product getProductDetailsById(Long id) {
        Optional<Product> getProducts = productRepo.findById(id);
        if(getProducts.isPresent()){
            return getProducts.get();
        }
        return null;
    }

    @Override
    public Product updateProductDetails(Long id, Product product) {
        Optional<Product> getProducts = productRepo.findById(id);
        if(getProducts.isEmpty()){
            throw new IllegalArgumentException("Product not found");
        }
        Product updateProduct = productRepo.save(product);
        updateProduct.setId(id);
        updateProduct.setLastUpdatedAt(new Date());
        return updateProduct;
    }

    @Override
    public Product createProduct(Product product) {
        if(product.getId() != null){
            throw new IllegalArgumentException("Product id Should be null");
        }
        return productRepo.save(product);
    }

    @Override
    public void deleteProductById(Long id) {
        Optional<Product> getProducts = productRepo.findById(id);
        if(getProducts.isEmpty()){
            throw new IllegalArgumentException("Product not found");
        }
        productRepo.deleteById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return products;
    }
}
