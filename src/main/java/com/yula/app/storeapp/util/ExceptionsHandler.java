package com.yula.app.storeapp.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionsHandler.class);

    @ExceptionHandler
    private ResponseEntity<ProductErrorResponse> handleException(ProductNotFoundException e) {
        logger.info(e.getClass().getSimpleName() + " - продукт по ID не найден");
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);   //  возвращаем пустой результат со статусом 404 -NOT_FOUND
    }

    @ExceptionHandler
    private ResponseEntity<ProductErrorResponse> handleExceptionWithMessage(ProductNotFoundExceptionCodeMsg e) {
        logger.info(e.getClass().getSimpleName() + " - продукт по данным параметрам не найден");
        return new ResponseEntity<>(new ProductErrorResponse(HttpStatus.NOT_FOUND.value(), "Product with this data is not found"), HttpStatus.NOT_FOUND);    // возвращаем объект с полями Error code + Error message
    }

    @ExceptionHandler
    private ResponseEntity<ProductErrorResponse> handleException(ProductNotCreatedException e) {
        logger.info(e.getClass().getSimpleName());
        ProductErrorResponse response = new ProductErrorResponse(
                e.getMessage()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
