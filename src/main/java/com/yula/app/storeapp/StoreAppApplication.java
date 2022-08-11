package com.yula.app.storeapp;

import com.yula.app.storeapp.models.Product_en;
import com.yula.app.storeapp.models.Product_ru;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;

@SpringBootApplication
public class StoreAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreAppApplication.class, args);
//        Product_ru product_ru = new Product_ru("Груши", "Китай", 250);
//        Product_en product_en = new Product_en("Pear", "China", 5);
//
//        product_ru.setProduct_en(product_en);
//        product_en.setProduct_ru(product_ru);

    }
}
