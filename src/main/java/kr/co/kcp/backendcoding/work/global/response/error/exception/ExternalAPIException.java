package kr.co.kcp.backendcoding.work.global.response.error.exception;

import kr.co.kcp.backendcoding.work.global.response.error.dto.ErrorCode;

public class ExternalAPIException extends BusinessException{

    public ExternalAPIException(ErrorCode errorCode) {
        super(errorCode);
    }
}
