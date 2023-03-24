package com.yula.app.storeapp.dto.client;

import javax.validation.constraints.NotNull;

public class ClientProductDTO {
    @NotNull
    private Integer id;

    private ClientPriceDTO price;
    private ClientTranslationDTO translation;

    public ClientProductDTO() {
    }

    public ClientProductDTO(Integer id, ClientPriceDTO price, ClientTranslationDTO translation) {
        this.id = id;
        this.price = price;
        this.translation = translation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClientPriceDTO getPrice() {
        return price;
    }

    public void setPrice(ClientPriceDTO price) {
        this.price = price;
    }

    public ClientTranslationDTO getTranslation() {
        return translation;
    }

    public void setTranslation(ClientTranslationDTO translation) {
        this.translation = translation;
    }
}
