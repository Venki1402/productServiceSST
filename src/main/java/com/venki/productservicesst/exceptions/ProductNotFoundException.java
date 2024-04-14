package com.venki.productservicesst.exceptions;

public class ProductNotFoundException extends RuntimeException {
    private Long id;
    public ProductNotFoundException(Long id,String message){
        super(message);
        this.id = id;
    }
}
