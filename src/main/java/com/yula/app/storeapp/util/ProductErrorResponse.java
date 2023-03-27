package com.yula.app.storeapp.util;

public class ProductErrorResponse {

    private int errorCode;
    private String errorMessage;

    public ProductErrorResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ProductErrorResponse(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ProductErrorResponse(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
