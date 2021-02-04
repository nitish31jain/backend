package com.nitish.backend.model.common;

import lombok.Data;

@Data
public class InvalidField {
    private final String name;
    private final String message;

    public InvalidField(String name, String message) {
        this.name = name;
        this.message = message;
    }
}
