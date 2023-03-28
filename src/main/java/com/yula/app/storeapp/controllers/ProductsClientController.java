package com.yula.app.storeapp.controllers;

import com.yula.app.storeapp.models.Product;
import com.yula.app.storeapp.services.ClientProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/")
public class ProductsClientController {

    private final ClientProductService clientProductService;

    @Autowired
    public ProductsClientController(ClientProductService clientProductService) {
        this.clientProductService = clientProductService;
    }

    //запрос всего списка продуктов с указанием языка и валюты
    @GetMapping("/products")
    public List<Product> getProducts(@RequestParam("currency_code") @NotBlank String currency_code,
                                     @RequestParam("language_code") @NotBlank String language_code,
                                     @RequestParam(required = false, defaultValue = "0") int page,
                                     @RequestParam(required = false, defaultValue = "3") int size) {
        return clientProductService.findAll(currency_code, language_code, PageRequest.of(page, size));
    }

    //запрос продукта по id
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") int id, @RequestParam("currency_code") @NotBlank String currency_code,
                              @RequestParam("language_code") @NotBlank String language_code) {
        return clientProductService.findByID(id, currency_code, language_code);
    }

    @GetMapping("/products/search")
    public List<Product> searchProducts(@RequestParam("currency_code") @NotBlank String currency_code,
                                        @RequestParam("language_code") @NotBlank String language_code,
                                        @RequestParam("keyword") @NotBlank String keyword,
                                        @RequestParam(required = false, defaultValue = "0") int page,
                                        @RequestParam(required = false, defaultValue = "0") int size) {
        return clientProductService.findByNameOrDescription(currency_code, language_code, keyword, PageRequest.of(page, size));
    }

}
