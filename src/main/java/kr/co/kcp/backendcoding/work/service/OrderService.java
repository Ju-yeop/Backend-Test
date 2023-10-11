package kr.co.kcp.backendcoding.work.service;

import static kr.co.kcp.backendcoding.work.global.response.error.dto.ErrorCode.ORDER_NOT_FOUND;

import kr.co.kcp.backendcoding.work.domain.Order;
import kr.co.kcp.backendcoding.work.dto.order.GetOrderRes;
import kr.co.kcp.backendcoding.work.global.response.error.exception.BusinessException;
import kr.co.kcp.backendcoding.work.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public GetOrderRes getOrder(String orderId) {
        Order order = orderRepository.findByOrderId(orderId)
                .orElseThrow(() -> new BusinessException(ORDER_NOT_FOUND));
        return new GetOrderRes(order);
    }
}
