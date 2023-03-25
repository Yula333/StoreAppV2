package com.yula.app.storeapp.services;

import com.yula.app.storeapp.models.Product;

import java.util.List;

public interface ClientProductServiceInterface {
    public List<Product> findAll(String currency_code, String language_code);

    public Product findByID(Integer id, String currency_code, String language_code);

    public List<Product> findByNameOrDescription(String currency_code, String language_code, String keyword);
}
