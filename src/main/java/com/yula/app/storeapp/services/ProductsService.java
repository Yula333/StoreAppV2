package com.yula.app.storeapp.services;

import com.yula.app.storeapp.models.Product;

import java.util.Date;
import java.util.List;

public interface ProductsService {

    public List<Product> findAll();
    public Product findOne(int id);
    public void save(Product product);
    public void update(int id, Product updatedProduct);

    //метод для удаления продукта
    public void delete(int id);

    //Поиск по имени или описанию
//    public List<Product> findByNameOrDescription(String keyword);

}
