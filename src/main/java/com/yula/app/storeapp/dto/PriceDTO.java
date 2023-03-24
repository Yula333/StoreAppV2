package com.yula.app.storeapp.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class PriceDTO {
    @DecimalMin(value = "1.0", message = "Price should be greater than 0")
    private BigDecimal value;
    @NotNull
    private String currency;
    @NotNull
    private String currency_code;

    public PriceDTO() {
    }

    public PriceDTO(BigDecimal value, String currency, String currency_code) {
        this.value = value;
        this.currency = currency;
        this.currency_code = currency_code;
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

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }
}
