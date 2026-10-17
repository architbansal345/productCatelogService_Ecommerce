package com.example.productcatelogservice.mapper;

import com.example.productcatelogservice.dtos.CategoryDTO;
import com.example.productcatelogservice.dtos.FakeStoreDto;
import com.example.productcatelogservice.dtos.ProductDTO;
import com.example.productcatelogservice.models.Category;
import com.example.productcatelogservice.models.Product;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public Product from(FakeStoreDto dto) {
        if (dto == null) {
            return null;
        }

        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getTitle());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setImageURL(dto.getImage());

        Category category = new Category();
        category.setName(dto.getCategory());
        product.setCategory(category);

        return product;
    }

    public FakeStoreDto Ffrom(Product product) {
        if (product == null) {
            return null;
        }

        FakeStoreDto dto = new FakeStoreDto();
        dto.setId(product.getId());
        dto.setTitle(product.getName());
        dto.setPrice(product.getPrice());
        dto.setDescription(product.getDescription());
        dto.setImage(product.getImageURL());

        if (product.getCategory() != null) {
            dto.setCategory(product.getCategory().getName());
        }

        return dto;
    }

    public ProductDTO Pfrom(Product product){
        if (product == null) {
            return null;
        }
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setImageUrl(product.getImageURL());
        productDTO.setPrice(product.getPrice());
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName(product.getCategory().getName());
        categoryDTO.setDescription(product.getCategory().getDescription());
        productDTO.setCategory(categoryDTO);
        return productDTO;
    }

    public Product from(ProductDTO productDTO) {
        if (productDTO == null) {
            return null;
        }

        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setImageURL(productDTO.getImageUrl());
        product.setPrice(productDTO.getPrice());

        if (productDTO.getCategory() != null) {
            Category category = new Category();
            category.setName(productDTO.getCategory().getName());
            category.setDescription(
                    productDTO.getCategory().getDescription()
            );
            product.setCategory(category);
        }

        return product;
    }
    public FakeStoreDto toFakeStoreDto(ProductDTO dto) {
        if (dto == null) {
            return null;
        }

        FakeStoreDto fakeStoreDto = new FakeStoreDto();
        fakeStoreDto.setId(dto.getId());
        fakeStoreDto.setTitle(dto.getName());
        fakeStoreDto.setPrice(dto.getPrice());
        fakeStoreDto.setDescription(dto.getDescription());
        fakeStoreDto.setImage(dto.getImageUrl());

        if (dto.getCategory() != null) {
            fakeStoreDto.setCategory(dto.getCategory().getName());
        }

        return fakeStoreDto;
    }

}
