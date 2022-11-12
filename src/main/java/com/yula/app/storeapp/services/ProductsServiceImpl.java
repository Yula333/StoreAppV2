package com.yula.app.storeapp.services;

import com.yula.app.storeapp.models.Product_ru;
import com.yula.app.storeapp.repositories.ProductsRepository;
import com.yula.app.storeapp.util.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductsService{

    //внедрим репозиторий
    private final ProductsRepository productsRepository;

    @Autowired
    public ProductsServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    //метод для получения всех продуктов
    public List<Product_ru> findAll(){
        return productsRepository.findAll();
    }

    //метод для поиска продукта по id
    public Product_ru findOne(int id){
        Optional<Product_ru> foundProduct = productsRepository.findById(id);
        return foundProduct.orElseThrow(ProductNotFoundException::new);   //возвращаем найденный продукт по id иначе новый объект нашего исключения
    }

    //метод для сохранения продукта в БД
    public void save(Product_ru product_ru){
        product_ru.setCreatedAt(new Date());
        productsRepository.save(product_ru);
    }

    //метод обновления продукта
    public void update(int id, Product_ru updatedProduct){
        updatedProduct.setId(id);
        updatedProduct.setUpdatedAt(new Date());
        productsRepository.save(updatedProduct);
    }

    //метод для удаления продукта
    public void delete(int id){
        productsRepository.deleteById(id);
    }

    //Поиск по имени или описанию
    public List<Product_ru> findByNameOrDescription(String keyword){
        return productsRepository.findByNameOrDescription(keyword);
    }
}
