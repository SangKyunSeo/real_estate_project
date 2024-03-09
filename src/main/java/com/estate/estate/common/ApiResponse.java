package com.estate.estate.common;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)

public class ApiResponse<T> {

    private String code;
    private String message;
    private T data;

    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>("","",null);
    }
    public static <T> ApiResponse<T> success(T data){
        return new ApiResponse<>("","", data);
    }

    public static ApiResponse<Object> error(ErrorCode errorCode){
        return new ApiResponse<>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    public static ApiResponse<Object> error(ErrorCode errorCode, String message){
        return new ApiResponse<>(errorCode.getCode(), message, null);
    }




}
