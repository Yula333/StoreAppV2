package com.yula.app.storeapp.controllers;

import com.yula.app.storeapp.dto.admin.RequestProductDTO;
import com.yula.app.storeapp.models.*;
import com.yula.app.storeapp.services.ProductsService;
import com.yula.app.storeapp.util.ProductNotCreatedException;
import org.modelmapper.ModelMapper;
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
//@Api(value = "product resources")
public class ProductsController {

    private final ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    //запрос всего списка продуктов
    @GetMapping("/products")
//    @ApiOperation(value = "show all products", response = Product.class)
    public List<Product> getProducts() {
        return productsService.findAll();   //Jackson конвертирует эти объекты в JSON
    }

    //запрос продукта по id
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") int id) {
        return productsService.findByID(id);
    }


    //создание и сохранение в БД нового продукта
    @PostMapping("/products")
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid Product product, BindingResult bindingResult) {
        // сообщение об ошибке, если продукт не корректный, не прошел валидацию
        if (bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {                                    //по каждой ошибке создадим сообщение
                errorMsg.append(error.getField())                               //на каком поле совершена ошибка
                        .append(" - ").append(error.getDefaultMessage())        //сообщение какая ошибка
                        .append(";");
            }
            //выбросим исключение и пошлем клиенту JSON с ошибкой
            throw new ProductNotCreatedException(errorMsg.toString());
        }
        //если продукт валидный сохраняем в БД
        productsService.save(product);
        // отправляем HTTP ответ с пустым телом и статусом 200 - ОК
        return ResponseEntity.ok(HttpStatus.OK);
    }

    //изменение продукта в БД
    @PutMapping("/products")
    public ResponseEntity<HttpStatus> updateProduct(@RequestBody @Valid Product product, BindingResult bindingResult) {
        // если продукт не корректный, не прошел валидацию
        if (bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {                                    //по каждой ошибке создадим сообщение
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
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") int id) {
        productsService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private static Product convertToProduct(RequestProductDTO requestProductDTO) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(requestProductDTO.getPrice(), Price.class);
        modelMapper.map(requestProductDTO.getTranslation(), Translation.class);
        Product product = modelMapper.map(requestProductDTO, Product.class);
        return product;
    }

    private void enrichProduct(Product product) {

    }

}
