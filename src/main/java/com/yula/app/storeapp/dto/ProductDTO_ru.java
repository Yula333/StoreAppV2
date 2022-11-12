package com.yula.app.storeapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yula.app.storeapp.models.Product_en;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDTO_ru {
    private String name;

    private String description;

    private int price;

    private Product_en product_en;

    public Product_en getProduct_en() {
        return product_en;
    }

    public void setProduct_en(Product_en product_en) {
        this.product_en = product_en;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price
                ;
    }
}
