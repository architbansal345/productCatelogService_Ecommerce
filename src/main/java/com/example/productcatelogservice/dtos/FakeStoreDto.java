package com.example.productcatelogservice.dtos;

import com.example.productcatelogservice.models.Category;
import com.example.productcatelogservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreDto {
    private Long id;
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;
}

