package com.yula.app.storeapp.dto;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class TranslationDTO {

    @NotBlank(message = "Name should not be empty")
    @Length(max = 200)
    private String name_prod;

    @Length(max = 300)
    private String description;

    @NotBlank(message = "Language should not be empty")
    private String language;

    public TranslationDTO() {
    }

    public TranslationDTO(String name_prod, String description, String language) {
        this.name_prod = name_prod;
        this.description = description;
        this.language = language;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
