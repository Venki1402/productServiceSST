package com.venki.productservicesst.controllers;

import com.venki.productservicesst.dtos.ExceptionDto;
import com.venki.productservicesst.models.Product;
import com.venki.productservicesst.services.FakeStoreProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/home")
    public String test(){
        return "Its Working!!";
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return fakeStoreProductService.getProductById(id);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity getProductById(@PathVariable("id") Long id){
//        try {
//            Product product = fakeStoreProductService.getProductById(id);
//            ResponseEntity<Product> responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
//            return responseEntity;
//        }
//        catch (RuntimeException exception){
//            ExceptionDto exceptionDto = new ExceptionDto("Something went wrong","Do nothing");
//            ResponseEntity<ExceptionDto> responseEntity1 = new ResponseEntity<>(exceptionDto,HttpStatus.NOT_FOUND);
//            return responseEntity1;
//        }
//    }

    @GetMapping
    public List<Product> getAllProducts(){
        return fakeStoreProductService.getALlProducts();
    }
}
