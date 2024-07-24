package org.lorenzo.departmentservice.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorResponse {
    private int statusCode;
    private String message;
    private String errorId;

    public ErrorResponse(int statusCode, String message, String errorId) {
        this.statusCode = statusCode;
        this.message = message;
        this.errorId = errorId;
    }

    public ErrorResponse() {
        this.statusCode = 500;
        this.message = "Internal Server Error";
        this.errorId = "error-" + System.currentTimeMillis();

    }
}
