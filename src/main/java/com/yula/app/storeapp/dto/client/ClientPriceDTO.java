package com.yula.app.storeapp.dto.client;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ClientPriceDTO {

    @DecimalMin(value = "1.0", message = "Price should be greater than 0")
    private BigDecimal value;
    @NotNull
    private String currency;

    public ClientPriceDTO(BigDecimal value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public ClientPriceDTO() {
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
