package com.nitish.backend.model.common;

import lombok.Data;

import java.util.List;

@Data
public class ApiError {
    private String errorCode;
    private String errorMessage;
    private List<InvalidField> invalidFields;

    public ApiError() {
        this("unknown_error", "Unknown error occurred");
    }

    public ApiError(String errorCode, String errorMessage) {
        this(errorCode, errorMessage, null);
    }

    public ApiError(String errorCode, String errorMessage, List<InvalidField> invalidFields) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.invalidFields = invalidFields;
    }
}
