package com.yula.app.storeapp.services;

import com.yula.app.storeapp.models.Product;

import java.util.List;

public interface ProductsServiceInterface {

    public List<Product> findAll();

    public Product findByID(int id);

    public void save(Product product);

    public void update(int id, Product updatedProduct);

    public void delete(int id);

}
