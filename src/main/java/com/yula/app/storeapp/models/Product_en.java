package com.yula.app.storeapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Product_en {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @NotBlank(message = "Name should not be empty")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price_usd")
    @Min(value = 1, message = "Price should be greater than 0")
    private int price_usd;

    @OneToOne(mappedBy = "product_en", cascade = CascadeType.ALL)
    @JsonIgnore
    private Product_ru product_ru;

    public Product_en() {
    }

    public Product_en(String name, String description, int price_usd) {
        this.name = name;
        this.description = description;
        this.price_usd = price_usd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

}
