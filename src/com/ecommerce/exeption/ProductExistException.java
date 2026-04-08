package com.ecommerce.exeption;

public class ProductExistException extends RuntimeException {
    public ProductExistException(String message) {
        super(message);
    }
}
