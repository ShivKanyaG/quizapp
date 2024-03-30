package com.shiv.exceptionHandler;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ExceptionResponse {
    private String errorStatusCode;
    private String errorMessage;
    private String exceptionName;
}
