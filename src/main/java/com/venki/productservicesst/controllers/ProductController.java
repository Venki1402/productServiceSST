package com.venki.productservicesst.controllers;

import com.venki.productservicesst.models.Product;
import com.venki.productservicesst.services.FakeStoreProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // This controller is capable of handling HTTP API's
@RequestMapping("/products")
public class ProductController {


    private FakeStoreProductService fakeStoreProductService;
    ProductController(FakeStoreProductService fakeStoreProductService){
        this.fakeStoreProductService = fakeStoreProductService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return fakeStoreProductService.getProductById(id);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return fakeStoreProductService.getALlProducts();
    }
}
