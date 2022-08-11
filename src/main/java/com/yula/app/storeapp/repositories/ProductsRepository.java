package com.yula.app.storeapp.repositories;

import com.yula.app.storeapp.models.Product_ru;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Product_ru, Integer> {

}
