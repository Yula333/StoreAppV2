package com.yula.app.storeapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yula.app.storeapp.models.Product_ru;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDTO_en {

    private String name;

    private String description;

    private int price_usd;

    private Product_ru product_ru;

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

    public int getPrice_usd() {
        return price_usd;
    }

    public void setPrice_usd(int price_usd) {
        this.price_usd = price_usd;
    }

    public Product_ru getProduct_ru() {
        return product_ru;
    }

    public void setProduct_ru(Product_ru product_ru) {
        this.product_ru = product_ru;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price_usd=" + price_usd
                ;
    }
}
