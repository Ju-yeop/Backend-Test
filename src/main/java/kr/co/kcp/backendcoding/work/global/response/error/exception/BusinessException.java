package kr.co.kcp.backendcoding.work.global.response.error.exception;

import kr.co.kcp.backendcoding.work.global.response.error.dto.ErrorCode;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
    private final ErrorCode errorCode;

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
