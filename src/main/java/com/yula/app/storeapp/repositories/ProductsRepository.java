package com.yula.app.storeapp.repositories;

import com.yula.app.storeapp.models.Product;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Integer> {

    String QUERY_CURRENCY_AND_LANGUAGE = "SELECT product FROM Product product JOIN product.prices prices " +
            "JOIN product.translations translations WHERE prices.currency_code = :currency_code " +
            "AND translations.language_code = :language_code";

    String QUERY_ID_AND_CURRENCY_AND_LANGUAGE = "SELECT product FROM Product product JOIN product.prices prices " +
            "JOIN product.translations translations WHERE product.id = :id AND prices.currency_code = :currency_code " +
            "AND translations.language_code = :language_code";

    String QUERY_CURRENCY_AND_LANGUAGE_AND_KEYWORD = "SELECT product FROM Product product JOIN product.prices prices " +
            "JOIN product.translations translations WHERE prices.currency_code = :currency_code " +
            "AND translations.language_code = :language_code AND (translations.name_prod LIKE %:keyword% OR translations.description LIKE %:keyword%)";

    @Query(value = QUERY_ID_AND_CURRENCY_AND_LANGUAGE)
    Product findByIdProduct(@Param("id") Integer id, @Param("currency_code") String currency_code, @Param("language_code") String language_code);

    @Query(value = QUERY_CURRENCY_AND_LANGUAGE_AND_KEYWORD)
    List<Product> findByKeywordByPageRequest(@Param("currency_code") String currency_code, @Param("language_code") String language_code, @Param("keyword") String keyword, PageRequest pageRequest);

    @Query(value = QUERY_CURRENCY_AND_LANGUAGE)
    List<Product> findAllByPageRequest(@Param("currency_code") String currency_code, @Param("language_code") String language_code, PageRequest pageRequest);

}
