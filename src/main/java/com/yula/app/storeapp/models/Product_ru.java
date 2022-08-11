package com.yula.app.storeapp.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Product_ru {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @NotBlank(message = "Name should not be empty")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price_rub")
    @Min(value = 1, message = "Price should be greater than 0")
    private int price_rub;

    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")     // дд/мм/гггг
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date updatedAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="product_en_id", referencedColumnName = "id")
    private Product_en product_en;

    public Product_ru() {
    }

    public Product_ru(String name, String description, int price_rub, Date createdAt, Date updatedAt, Product_en product_en) {
        this.name = name;
        this.description = description;
        this.price_rub = price_rub;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.product_en = product_en;
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

    public int getPrice_rub() {
        return price_rub;
    }

    public void setPrice_rub(int price_rub) {
        this.price_rub = price_rub;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Product_en getProduct_en() {
        return product_en;
    }

    public void setProduct_en(Product_en product_en) {
        this.product_en = product_en;
    }
}
