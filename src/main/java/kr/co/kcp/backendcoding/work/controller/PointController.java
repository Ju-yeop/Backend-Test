package kr.co.kcp.backendcoding.work.controller;

import kr.co.kcp.backendcoding.work.domain.enums.PointType;
import kr.co.kcp.backendcoding.work.global.response.CustomRes;
import kr.co.kcp.backendcoding.work.service.PointService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/point")
@RequiredArgsConstructor
public class PointController {
    private final PointService pointService;

    @GetMapping
    public CustomRes<Object> getPoint(
            @RequestParam PointType pointType){
        Object data = pointService.getPoint(pointType);
        return CustomRes.of(data, "포인트 조회 성공");
    }
}
