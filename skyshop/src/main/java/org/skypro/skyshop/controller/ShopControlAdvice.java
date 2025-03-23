package org.skypro.skyshop.controller;

import org.skypro.skyshop.Error.ShopError;
import org.skypro.skyshop.service.NoSuchProductException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopControlAdvice {


    @ExceptionHandler(NoSuchProductException.class)
    public ResponseEntity<ShopError> handleNoSuchProductException(NoSuchProductException ex) {
        ShopError error = new ShopError("PRODUCT_NOT_FOUND", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
