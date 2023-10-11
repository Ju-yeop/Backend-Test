package kr.co.kcp.backendcoding.work.controller;

import jakarta.validation.constraints.Size;
import kr.co.kcp.backendcoding.work.dto.order.GetOrderRes;
import kr.co.kcp.backendcoding.work.global.response.CustomRes;
import kr.co.kcp.backendcoding.work.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public CustomRes<GetOrderRes> getOrder(@RequestParam @Size(max = 6) String orderId){
        GetOrderRes data = orderService.getOrder(orderId);
        return CustomRes.of(data, "주문 정보 조회 성공");
    }
}
