package com.example.productcatelogservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel{
    private String name;
    private String description;
    private String ImageURL;
    private Double price;
    private Category category;
    private boolean isSaleSpecific; // TO show DTO only
}
