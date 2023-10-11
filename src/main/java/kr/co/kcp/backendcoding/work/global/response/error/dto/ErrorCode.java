package kr.co.kcp.backendcoding.work.global.response.error.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "C-000", "내부 서버 오류"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "C-001", "리소스를 찾을 수 없음"),
    INVALID_TYPE_VALUE(HttpStatus.BAD_REQUEST, "C-002", "유효하지 않은 값 타입"),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "C-003", "허용되지 않은 Request Method 호출"),
    METHOD_ARGUMENT_NOT_VALID(HttpStatus.BAD_REQUEST, "C-004", "요청 인자가 유효하지 않음"),
    ORDER_NOT_FOUND(HttpStatus.NOT_FOUND, "O-000", "주문 정보를 찾을 수 없습니다."),
    EXTERNAL_API_ERROR(HttpStatus.BAD_REQUEST, "E-000", "외부 API 오류");

    private final HttpStatus status;
    private final String code;
    private final String message;
}