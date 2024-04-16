package com.venki.productservicesst.services;

import com.venki.productservicesst.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    List<Product> getALlProducts();
    Product createProduct(Product product);
}
