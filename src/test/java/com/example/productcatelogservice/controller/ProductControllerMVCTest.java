package com.example.productcatelogservice.controller;

import com.example.productcatelogservice.controllers.ProductController;
import com.example.productcatelogservice.dtos.ProductDTO;
import com.example.productcatelogservice.mapper.Mapper;
import com.example.productcatelogservice.models.Product;
import com.example.productcatelogservice.services.IProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerMVCTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean(name = "storageProductService")
    private IProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private Mapper mapper;
    @Test
    public void TestgetProductDetailsByIdAPI() throws Exception {
        Long id = 1L;
        Product product = new Product();
        product.setId(1L);
        product.setName("test");
        when(productService.getProductDetailsById(id)).thenReturn(product);

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(id);
        productDTO.setName("test");
        when(mapper.Pfrom(product)).thenReturn(productDTO);
        String expected = objectMapper.writeValueAsString(productDTO);
        mockMvc.perform(get("/products/1")).andExpect(status().isOk()).andExpect(
                content().string(expected)
        );
    }
}
