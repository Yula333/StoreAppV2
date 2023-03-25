package com.yula.app.storeapp.dto.admin;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class ResponseTranslationDTO {

    @NotBlank(message = "Name should not be empty")
    @Length(max = 200)
    private String name_prod;

    @Length(max = 300)
    private String description;

    @NotBlank(message = "Language should not be empty")
    private String language_code;

    public ResponseTranslationDTO() {
    }

    public ResponseTranslationDTO(String name_prod, String description, String language_code) {
        this.name_prod = name_prod;
        this.description = description;
        this.language_code = language_code;
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
}
