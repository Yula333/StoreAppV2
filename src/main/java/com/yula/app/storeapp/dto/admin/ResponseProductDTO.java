package com.yula.app.storeapp.dto.admin;

import com.yula.app.storeapp.models.Price;
import com.yula.app.storeapp.models.Translation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class ResponseProductDTO {
    @NotNull
    private Integer id;

    @NotNull
    private Date createdAt;
    private Date updatedAt;

    @NotBlank
    private List<ResponsePriceDTO> price;

    @NotBlank
    private List<ResponseTranslationDTO> translation;

    public ResponseProductDTO() {
    }

    public ResponseProductDTO(Integer id, Date createdAt, Date updatedAt, List<ResponsePriceDTO> price, List<ResponseTranslationDTO> translation) {
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

    public List<ResponsePriceDTO> getPrice() {
        return price;
    }

    public void setPrice(List<ResponsePriceDTO> price) {
        this.price = price;
    }

    public List<ResponseTranslationDTO> getTranslation() {
        return translation;
    }

    public void setTranslation(List<ResponseTranslationDTO> translation) {
        this.translation = translation;
    }
}
