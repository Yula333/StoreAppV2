package com.yula.app.storeapp.controllers;

import com.yula.app.storeapp.models.Product_ru;
import com.yula.app.storeapp.services.ProductsService;
import com.yula.app.storeapp.util.ProductErrorResponse;
import com.yula.app.storeapp.util.ProductNotCreatedException;
import com.yula.app.storeapp.util.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController     //@Controller + @ResponseBody над каждым методом
@RequestMapping("/api")
public class ProductsController {

    private final ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    //запрос всего списка продуктов
    @GetMapping("/products")
    public List<Product_ru> getProducts() {
        return productsService.findAll();   //Jackson конвертирует эти объекты в JSON
    }

    //запрос продукта по id
    @GetMapping("/products/{id}")
    public Product_ru getProduct(@PathVariable("id") int id){
        return productsService.findOne(id);
    }

    //создание и сохранение в БД нового продукта
    @PostMapping("/products")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid Product_ru product_ru, BindingResult bindingResult){
        // если продукт не корректный, не прошел валидацию
        if(bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors){                                    //по каждой ошибке создадим сообщение
                errorMsg.append(error.getField())                               //на каком поле совершена ошибка
                        .append(" - ").append(error.getDefaultMessage())        //сообщение какая ошибка
                        .append(";");
            }
            //выбросим исключение и пошлем клиенту JSON с ошибкой
            throw new ProductNotCreatedException(errorMsg.toString());
        }
            //если продукт валидный сохраняем в БД
        productsService.save(product_ru);
        // отправляем HTTP ответ с пустым телом и статусом 200 - ОК
        return ResponseEntity.ok(HttpStatus.OK);
    }

    //изменение продукта в БД
    @PutMapping("/products")
    public ResponseEntity<HttpStatus> updateProduct(@RequestBody @Valid Product_ru product, BindingResult bindingResult){
        // если продукт не корректный, не прошел валидацию
        if(bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors){                                    //по каждой ошибке создадим сообщение
                errorMsg.append(error.getField())                               //на каком поле совершена ошибка
                        .append(" - ").append(error.getDefaultMessage())        //сообщение какая ошибка
                        .append(";");
            }
            //выбросим исключение и пошлем клиенту JSON с ошибкой
            throw new ProductNotCreatedException(errorMsg.toString());
        }
        //если продукт валидный обновляем в БД
        productsService.update(product.getId(), product);
        // отправляем HTTP ответ с пустым телом и статусом 200 - ОК
        return ResponseEntity.ok(HttpStatus.OK);
    }

    //удаление продукта по id
    @DeleteMapping("/products/{id}")
    public  ResponseEntity<HttpStatus> deleteProduct (@PathVariable("id") int id){
        productsService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<ProductErrorResponse> handleException(ProductNotFoundException e) {
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);    //  NOT_FOUND - 404 статус
    }

    @ExceptionHandler
    private ResponseEntity<ProductErrorResponse> handleException(ProductNotCreatedException e) {
        ProductErrorResponse response = new ProductErrorResponse(
                e.getMessage()
//                HttpStatus.BAD_REQUEST.value()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
