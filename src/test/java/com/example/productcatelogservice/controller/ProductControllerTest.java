package com.example.productcatelogservice.controller;

import com.example.productcatelogservice.controllers.ProductController;
import com.example.productcatelogservice.dtos.ProductDTO;
import com.example.productcatelogservice.models.Product;
import com.example.productcatelogservice.services.IProductService;
import com.example.productcatelogservice.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockBean(name = "storageProductService")
    private IProductService productService;

    @Test
    public void TestGetProductDetailwithValidId(){
//        Arrange
        Long id = 5L;
        Product product = new Product();
        product.setId(id);
        product.setName("Mobile");
        when(productService.getProductDetailsById(id)).thenReturn(product);

//        Act
        ResponseEntity<ProductDTO> response =  productController.getProductDetailsById(id);

//        Assert
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(id, response.getBody().getId());
        assertEquals(product.getName(), response.getBody().getName());
        verify(productService, times(1)).getProductDetailsById(id);
    }

    @Test
    public void TestGetProductDetailswithInvalidId(){
//        Arrange
        Long id = -5L;

        //Act and assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> productController.getProductDetailsById(id));
        assertEquals("Id cannot be -ve" , exception.getMessage());
        verify(productService, times(0)).getProductDetailsById(id);
    }

    @Test
    public  void TestProductDetailsWithProductNotFound(){
        Long id = 2L;
        when(productService.getProductDetailsById(id)).thenReturn(null);
        Exception exception = assertThrows(RuntimeException.class , ()-> productController.getProductDetailsById(id));
        assertEquals("Product not found" , exception.getMessage());
    }
}
