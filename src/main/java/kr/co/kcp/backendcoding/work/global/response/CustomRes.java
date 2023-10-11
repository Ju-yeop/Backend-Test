package kr.co.kcp.backendcoding.work.global.response;

import lombok.AccessLevel;
import lombok.Getter;

import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomRes<T>{

    private final int code = 0;
    private T data;
    private String message;

    public CustomRes(T data) {
        this.data = data;
    }

    public CustomRes(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public static <T> CustomRes<T> of(final T data) {
        return new CustomRes<>(data);
    }

    public static <T> CustomRes<T> of(final T data, final String message) {
        return new CustomRes<>(data, message);
    }


}