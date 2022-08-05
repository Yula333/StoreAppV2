package com.yula.app.storeapp.services;

import com.yula.app.storeapp.models.Product;
import com.yula.app.storeapp.repositories.ProductsRepository;
import com.yula.app.storeapp.util.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProductsService {

    //внедрим репозиторий
    private final ProductsRepository productsRepository;

    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    //метод для получения всех продуктов
    public List<Product> findAll(){
        return productsRepository.findAll();
    }

    //метод для поиска продукта по id
    public Product findOne(int id){
        Optional<Product> foundProduct = productsRepository.findById(id);
        return foundProduct.orElseThrow(ProductNotFoundException::new);   //возвращаем найденный продукт по id иначе новый объект нашего исключения
    }

    //метод для сохранения продукта в БД
    @Transactional
    public void save(Product product){
        product.setCreatedAt(new Date());
        productsRepository.save(product);
    }

    //метод обновления продукта
    @Transactional
    public void update(int id, Product updatedProduct){
        updatedProduct.setId(id);
        updatedProduct.setUpdatedAt(new Date());
        productsRepository.save(updatedProduct);
    }

    //метод для удаления продукта
    @Transactional
    public void delete(int id){
        productsRepository.deleteById(id);
    }
}
