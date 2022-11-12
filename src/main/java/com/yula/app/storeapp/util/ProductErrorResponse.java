package com.yula.app.storeapp.util;
import org.springframework.web.client.HttpStatusCodeException;

public class ProductErrorResponse {

    private String errorMessage;
    private int errorCode;

    public ProductErrorResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }
//    public ProductErrorResponse(String errorMessage, int errorCode) {
//        this.errorMessage = errorMessage;
//        this.errorCode = errorCode;
//    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

//    public int getErrorCode() {
//        return errorCode;
//    }
//
//    public void setErrorCode(int errorCode) {
//        this.errorCode = errorCode;
//    }
}
