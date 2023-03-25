package com.yula.app.storeapp.services;

import com.yula.app.storeapp.models.Product;
import com.yula.app.storeapp.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientProductService implements ClientProductServiceInterface {

    @Autowired
    private final ProductsRepository productsRepository;

    public ClientProductService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Product> findAll(String currency_code, String language_code) {
        return productsRepository.findAllProducts(currency_code, language_code);
    }

    public Product findByID(Integer id, String currency_code, String language_code) {
        return productsRepository.findByIdProduct(id, currency_code, language_code);
    }

    public List<Product> findByNameOrDescription(String currency_code, String language_code, String keyword) {
        return productsRepository.findByKeyword(currency_code, language_code, keyword);
    }
}
