package com.yula.app.storeapp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Price {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "value")
    @DecimalMin(value = "1.0", message = "Price should be greater than 0")
    private BigDecimal value;

    @Column(name = "currency")
    @NotNull
    private String currency;

    @Column(name = "currency_code")
    @NotNull
    private String currency_code;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="product_id", referencedColumnName = "id")
    private Product product;

//    @JsonBackReference
//    @OneToOne
//    @JoinColumn(name="translation_id", referencedColumnName = "id")
//    private Translation translation;

    public Price() {
    }

    public Price(Integer id, BigDecimal value, String currency, String currency_code, Product product) {
        this.id = id;
        this.value = value;
        this.currency = currency;
        this.currency_code = currency_code;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}