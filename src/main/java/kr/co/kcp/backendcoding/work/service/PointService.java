package kr.co.kcp.backendcoding.work.service;

import static kr.co.kcp.backendcoding.work.global.response.error.dto.ErrorCode.EXTERNAL_API_ERROR;
import static kr.co.kcp.backendcoding.work.global.util.Constants.ExternalGetPointBaseUrl;
import static kr.co.kcp.backendcoding.work.global.util.Constants.ExternalGetPointParam;
import static kr.co.kcp.backendcoding.work.global.util.Constants.ExternalGetPointResKey;
import static kr.co.kcp.backendcoding.work.global.util.Constants.ExternalGetPointUrlPath;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import kr.co.kcp.backendcoding.work.domain.enums.PointType;
import kr.co.kcp.backendcoding.work.global.response.error.exception.ExternalAPIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.util.retry.Retry;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class PointService {

    private final WebClient webClient;

    public PointService() {
        this.webClient = WebClient.builder()
                .baseUrl(ExternalGetPointBaseUrl)
                .build();
    }

    public Object getPoint(PointType pointType) {
        Map<String, Object> response = webClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder
                                .path(ExternalGetPointUrlPath)
                                .queryParam(ExternalGetPointParam, pointType.getValue())
                                .build())

                .retrieve()
                .bodyToMono(Map.class)
                .timeout(Duration.ofSeconds(5))
                .retryWhen(Retry.fixedDelay(3, Duration.ofMillis(1000))
                        .filter(throwable -> throwable instanceof TimeoutException))
                .onErrorMap(Exception.class, ex -> new ExternalAPIException(EXTERNAL_API_ERROR))
                .block();

        if (response == null){
            throw new ExternalAPIException(EXTERNAL_API_ERROR);
        }
        return response.get(ExternalGetPointResKey);

    }
}
