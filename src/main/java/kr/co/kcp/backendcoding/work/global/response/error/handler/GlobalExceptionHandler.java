package kr.co.kcp.backendcoding.work.global.response.error.handler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.kcp.backendcoding.work.global.response.error.dto.ErrorCode;
import kr.co.kcp.backendcoding.work.global.response.error.dto.ErrorResponse;
import kr.co.kcp.backendcoding.work.global.response.error.exception.BusinessException;
import kr.co.kcp.backendcoding.work.global.response.error.exception.ExternalAPIException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    protected ResponseEntity<ErrorResponse> handleNoHandlerFoundException(NoHandlerFoundException e,
            HttpServletRequest request) {
        final ErrorResponse response =  ErrorResponse.of(ErrorCode.NOT_FOUND);
        return new ResponseEntity<>(response, NOT_FOUND);
    }

    // HttpMessageConverter 에서 등록한 HttpMessageConverter binding 못 할 경우 발생 - @Valid
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e,
            HttpServletRequest request) {
        log.info("MethodArgumentNotValidException: {} - {}", e.getMessage(), request.getRequestURL());
        final ErrorResponse response = ErrorResponse.of(ErrorCode.METHOD_ARGUMENT_NOT_VALID, e.getBindingResult());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    // @ModelAttribute 으로 binding error 발생시 BindException
    @ExceptionHandler(BindException.class)
    protected ResponseEntity<ErrorResponse> handleBindException(
            BindException e, HttpServletRequest request) {
        log.info("BindException: {} - {}", e.getMessage(), request.getRequestURL());
        final ErrorResponse response = ErrorResponse.of(
                ErrorCode.METHOD_ARGUMENT_NOT_VALID, e.getBindingResult());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    // 지원하지 않은 HTTP method 호출 할 경우 발생
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException e,
            HttpServletRequest request) {
        log.info("HttpRequestMethodNotSupportedException: {} - {}", e.getMessage(), request.getRequestURL());
        final ErrorResponse response = ErrorResponse.of(ErrorCode.METHOD_NOT_ALLOWED);
        return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
    }

    // @RequestParam 필수 인자 null 일 경우 발생
    @ExceptionHandler(MissingServletRequestParameterException.class)
    protected ResponseEntity<ErrorResponse> handleMissingParamsException(
            MissingServletRequestParameterException e,
            HttpServletRequest request) {
        log.info("MissingServletRequestParameterException: {} - {}", e.getMessage(), request.getRequestURL());
        final ErrorResponse response = ErrorResponse.of(ErrorCode.METHOD_ARGUMENT_NOT_VALID);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // RequestParam Enum type 일치하지 않아 binding 못할 경우 발생
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException e,
            HttpServletRequest request) {
        log.error("MethodArgumentTypeMismatchException: {} - {}", e.getMessage(), request.getRequestURL());
        final ErrorResponse response = ErrorResponse.of(e);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorResponse> handleBusinessException(
            BusinessException e,
            HttpServletRequest request) {
        log.info("BusinessException: {} - {}", e.getErrorCode().getMessage(), request.getRequestURL());
        final ErrorCode errorCode = e.getErrorCode();
        final ErrorResponse response = ErrorResponse.of(errorCode);
        return new ResponseEntity<>(response, errorCode.getStatus());
    }

    @ExceptionHandler(ExternalAPIException.class)
    protected ResponseEntity<ErrorResponse> handleExternalAPIException(
            ExternalAPIException e,
            HttpServletRequest request) {
        log.warn("ExternalAPIException: {} - {}", e.getErrorCode().getMessage(), request.getRequestURL());
        final ErrorCode errorCode = e.getErrorCode();
        final ErrorResponse response = ErrorResponse.of(errorCode);
        return new ResponseEntity<>(response, errorCode.getStatus());
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(
            Exception e, HttpServletRequest request) {
        log.error("Exception: {} - {}", e, request.getRequestURL());
        final ErrorResponse response =  ErrorResponse.of(ErrorCode.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(response, INTERNAL_SERVER_ERROR);
    }
}