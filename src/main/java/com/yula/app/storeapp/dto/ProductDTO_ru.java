package com.yula.app.storeapp.dto;

import com.yula.app.storeapp.models.Product_en;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ProductDTO {
    @NotBlank(message = "Name should not be empty")
    private String name;

    private String description;

    @Min(value = 1, message = "Price should be greater than 0")
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
}
