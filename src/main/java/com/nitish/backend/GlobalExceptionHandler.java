package com.nitish.backend;

import com.nitish.backend.exception.NotFoundException;
import com.nitish.backend.model.common.ApiError;
import com.nitish.backend.model.common.ErrorCodes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collections;
import java.util.List;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = NotFoundException.class)
    @ResponseBody
    public List<ApiError> handleNotFoundException(NotFoundException notFoundException) {
        log.error("Failed due to not found exception: {}", notFoundException.getMessage());
        return Collections.singletonList(
                new ApiError(ErrorCodes.RESOURCE_NOT_FOUND, notFoundException.getMessage()));
    }
}