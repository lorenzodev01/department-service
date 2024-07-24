package org.lorenzo.departmentservice.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ErrorResponseTest {

    @Test
    public void testCreateErrorResponse() {
        int statusCode = 404;
        String message = "Not Found";
        String errorId = "12345";

        ErrorResponse errorResponse = new ErrorResponse(statusCode, message, errorId);

        assertEquals(statusCode, errorResponse.getStatusCode());
        assertEquals(message, errorResponse.getMessage());
        assertEquals(errorId, errorResponse.getErrorId());
    }

    @Test
    public void testErrorResponseSettersAndGetters() {
        ErrorResponse errorResponse = new ErrorResponse();

        int statusCode = 500;
        String message = "Internal Server Error";
        String errorId = "67890";

        errorResponse.setStatusCode(statusCode);
        errorResponse.setMessage(message);
        errorResponse.setErrorId(errorId);

        assertEquals(statusCode, errorResponse.getStatusCode());
        assertEquals(message, errorResponse.getMessage());
        assertEquals(errorId, errorResponse.getErrorId());
    }
}
