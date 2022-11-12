package com.yula.app.storeapp.repositories;

import com.yula.app.storeapp.models.Product_ru;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Product_ru, Integer> {

    @Query("select p from Product_ru p where p.name like %?1% or p.description like %?1% or p.product_en.name like %?1% or p.product_en.description like %?1%  ")
    List<Product_ru> findByNameOrDescription(String keyword);

}
