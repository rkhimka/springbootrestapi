package com.example.shop.responsecontent;

import com.example.shop.models.errors.ApiError;
import com.example.shop.models.errors.ApiErrorResponse;

import java.util.List;

public final class ErrorResponse {
    private ErrorResponse() {
    }

    public static ApiErrorResponse badRequestApiResponse(String message) {
        return buildApiErrorResponse("BAD_REQUEST", message);
    }

    public static ApiErrorResponse notFoundApiResponse(String message) {
        return buildApiErrorResponse("NOT_FOUND", message);
    }

    public static ApiErrorResponse buildApiErrorResponse(String code, String msg) {
        return ApiErrorResponse
                .builder()
                .errors(List.of(buildApiError(code, msg)))
                .build();
    }

    public static ApiError buildApiError(String code, String msg) {
        return ApiError
                .builder()
                .code(code)
                .message(msg)
                .build();
    }
}
