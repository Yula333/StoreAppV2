package com.yula.app.storeapp.services;

import com.yula.app.storeapp.models.Product_ru;

import java.util.Date;
import java.util.List;

public interface ProductsService {

    public List<Product_ru> findAll();
    public Product_ru findOne(int id);
    public void save(Product_ru product_ru);
    public void update(int id, Product_ru updatedProduct);

    //метод для удаления продукта
    public void delete(int id);

    //Поиск по имени или описанию
    public List<Product_ru> findByNameOrDescription(String keyword);

}
