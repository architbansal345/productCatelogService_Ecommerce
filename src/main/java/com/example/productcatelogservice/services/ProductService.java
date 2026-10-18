package com.example.productcatelogservice.services;

import com.example.productcatelogservice.dtos.FakeStoreDto;
import com.example.productcatelogservice.dtos.ProductDTO;
import com.example.productcatelogservice.mapper.Mapper;
import com.example.productcatelogservice.models.Category;
import com.example.productcatelogservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.ResponseCache;
import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    private Mapper mapper;

    @Override
    public Product getProductDetailsById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreDto> fakeStoreDto = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreDto.class,id);
        if(fakeStoreDto.hasBody() && fakeStoreDto.getStatusCode().equals(HttpStatusCode.valueOf(200))){
            return mapper.from(fakeStoreDto.getBody());
        }
        return null;
    }

    @Override
    public Product updateProductDetails(Long id, Product product) {
        FakeStoreDto fakeStoreDto = mapper.Ffrom(product);
        ResponseEntity<FakeStoreDto> fakeStoreDtores = putForEntity("https://fakestoreapi.com/products/{id}", fakeStoreDto,FakeStoreDto.class,id);
        if(fakeStoreDtores.hasBody() && fakeStoreDtores.getStatusCode().equals(HttpStatusCode.valueOf(200))){
            return mapper.from(fakeStoreDtores.getBody());
        }
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProductById(Long id) {

    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    public <T> ResponseEntity<T> putForEntity(String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, HttpMethod.PUT, requestCallback, responseExtractor, uriVariables);
    }
}
