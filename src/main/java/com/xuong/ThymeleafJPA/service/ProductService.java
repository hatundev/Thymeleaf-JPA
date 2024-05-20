package com.xuong.ThymeleafJPA.service;

import com.xuong.ThymeleafJPA.entity.Product;
import com.xuong.ThymeleafJPA.request.ProductRequest;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();

    Product saveProduct(ProductRequest productRequest);

    Product updateProduct(ProductRequest productRequest);

    String deleteProduct(Long id);

    Optional<Product> getProduct(Long id);

    ProductRequest convertProductToProductRequest(Product product);

}
