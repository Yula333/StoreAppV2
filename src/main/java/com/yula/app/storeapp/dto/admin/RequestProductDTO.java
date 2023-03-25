package com.yula.app.storeapp.dto.admin;

import com.yula.app.storeapp.models.Price;
import com.yula.app.storeapp.models.Translation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class RequestProductDTO {

    @NotBlank
    private List<RequestPriceDTO> price;

    @NotBlank
    private List<ResponseTranslationDTO> translation;

    public RequestProductDTO() {
    }

    public RequestProductDTO(List<RequestPriceDTO> price, List<ResponseTranslationDTO> translation) {
        this.price = price;
        this.translation = translation;
    }

    public List<RequestPriceDTO> getPrice() {
        return price;
    }

    public void setPrice(List<RequestPriceDTO> price) {
        this.price = price;
    }

    public List<ResponseTranslationDTO> getTranslation() {
        return translation;
    }

    public void setTranslation(List<ResponseTranslationDTO> translation) {
        this.translation = translation;
    }
}
