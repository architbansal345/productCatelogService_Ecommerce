package com.example.productcatelogservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String name;
    private String description;
    private String ImageURL;
    private Double price;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;
    private boolean isSaleSpecific; // TO show DTO only
}
