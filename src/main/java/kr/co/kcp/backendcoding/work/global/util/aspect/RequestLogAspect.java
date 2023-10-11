package kr.co.kcp.backendcoding.work.global.util.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
@Slf4j
@RequiredArgsConstructor
public class RequestLogAspect {
    private final ObjectMapper mapper;

    private static final String REQUEST_FORMAT = "Request: Remote IP: %s, "
            + "Headers: %s, Method: %s, URI: %s, Parameter: %s";


    @Before("execution(* kr.co.kcp.backendcoding.work.controller.*.*(..))")
    public void requestLog(JoinPoint joinPoint){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes()).getRequest();

        log.info(getRequestJson(request));
    }

    private String getRequestJson(HttpServletRequest request){
        String remoteIp = getClientIp(request);
        String headers = getHeaders(request);
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String parameters = getParameters(request);
        return String.format(REQUEST_FORMAT, remoteIp, headers, method, uri, parameters);
    }

    public String getHeaders(HttpServletRequest request) {
        Map<String, String> headers = new HashMap<>();

        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName ->
                        headers.put(headerName, request.getHeader(headerName)));

        return toJson(headers);
    }

    private String getParameters(HttpServletRequest request){
        Map<String, String> parameters = new HashMap<>();

        request.getParameterNames().asIterator()
                .forEachRemaining(parameterName ->
                        parameters.put(parameterName, request.getParameter(parameterName)));

        return toJson(parameters);
    }

    private String toJson(Map<String, String> headers) {
        String json = "";
        try {
            json = mapper.writeValueAsString(headers);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    @SneakyThrows(UnknownHostException.class)
    private String getClientIp(HttpServletRequest request){
        String ip = request.getHeader("X-Forwarded-For");

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-RealIP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("REMOTE_ADDR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.equals("0:0:0:0:0:0:0:1") || ip.equals("127.0.0.1")) {
            InetAddress address = InetAddress.getLocalHost();
            ip = address.getHostName() + "/" + address.getHostAddress();
        }

        return ip;
    }


}
