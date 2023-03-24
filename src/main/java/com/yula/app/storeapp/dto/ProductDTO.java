package com.yula.app.storeapp.dto;

import com.yula.app.storeapp.models.Price;
import com.yula.app.storeapp.models.Translation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class ProductDTO {
    @NotNull
    private Integer id;

    @NotNull
    private Date createdAt;
    private Date updatedAt;

    @NotBlank
private List<Price> price;

    @NotBlank
    private List<Translation> translation;

    public ProductDTO() {
    }

    public ProductDTO(Integer id, Date createdAt, Date updatedAt, List<Price> price, List<Translation> translation) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.price = price;
        this.translation = translation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Price> getPrice() {
        return price;
    }

    public void setPrice(List<Price> price) {
        this.price = price;
    }

    public List<Translation> getTranslation() {
        return translation;
    }

    public void setTranslation(List<Translation> translation) {
        this.translation = translation;
    }
}
