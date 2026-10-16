package com.example.productcatelogservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private Long Id;
    private String Name;
    private String Description;
    private String ImageUrl;
    private Double Price;
    private CategoryDTO category;
}
