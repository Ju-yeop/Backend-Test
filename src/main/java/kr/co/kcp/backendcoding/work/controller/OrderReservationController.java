package kr.co.kcp.backendcoding.work.controller;

import jakarta.validation.Valid;
import kr.co.kcp.backendcoding.work.dto.orderReservation.PostOrderReservationReq;
import kr.co.kcp.backendcoding.work.dto.orderReservation.PostOrderReservationRes;
import kr.co.kcp.backendcoding.work.global.response.CustomRes;
import kr.co.kcp.backendcoding.work.service.OrderReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/order-reservation")
@RequiredArgsConstructor
public class OrderReservationController {

    private final OrderReservationService orderReservationService;

    @PostMapping
    public CustomRes<PostOrderReservationRes> postOrderReservation(
            @RequestBody @Valid PostOrderReservationReq postOrderReservationReq){
        postOrderReservationReq.validateAmount();

        PostOrderReservationRes data = orderReservationService
                .postOrderReservation(postOrderReservationReq);
        return CustomRes.of(data, "주문 예약 성공");
    }
}
