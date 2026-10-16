package com.example.productcatelogservice.services;

import com.example.productcatelogservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

public class ProductService {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    private Product getProductDetailsById(Long id){
        RestTemplate restTemplate = restTemplateBuilder.build();
        return null;
    }
}
