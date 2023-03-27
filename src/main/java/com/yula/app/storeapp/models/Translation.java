package com.yula.app.storeapp.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

@Entity
@ApiModel(value = "class translation")
public class Translation {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_prod")
    @NotBlank(message = "Name should not be empty")
    @Length(max = 200)
    @ApiModelProperty(value = "name of product")
    private String name_prod;

    @Column(name = "description")
    @Length(max = 300)
    @ApiModelProperty(value = "description of product")
    private String description;

    @Column(name = "language_code")
    @NotBlank(message = "Language code should not be empty")
    @ApiModelProperty(value = "language")
    private String language_code;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    public Translation() {
    }

    public Translation(Integer id, String name_prod, String description, String language_code, Product product) {
        this.id = id;
        this.name_prod = name_prod;
        this.description = description;
        this.language_code = language_code;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName_prod() {
        return name_prod;
    }

    public void setName_prod(String name_prod) {
        this.name_prod = name_prod;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage_code() {
        return language_code;
    }

    public void setLanguage_code(String language_code) {
        this.language_code = language_code;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
