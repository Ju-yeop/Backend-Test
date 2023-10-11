package kr.co.kcp.backendcoding.work.dto.order;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;
import kr.co.kcp.backendcoding.work.domain.Order;
import kr.co.kcp.backendcoding.work.dto.orderMenu.OrderMenusDto;
import kr.co.kcp.backendcoding.work.dto.orderPayment.OrderPaymentsDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GetOrderRes {
    @NotNull
    @Min(0)
    private int orderAmount;

    @NotBlank
    @Size(max = 0)
    private String orderDate;

    @NotEmpty
    private List<OrderMenusDto> orderMenus;

    @NotEmpty
    private List<OrderPaymentsDto> orderPayments;

    public GetOrderRes(Order order) {
        orderAmount = order.getOrderAmount();
        orderDate = order.getOrderDate().toString();
        orderMenus = order.getOrderMenus().stream()
                .map(OrderMenusDto::new)
                .collect(Collectors.toList());
        orderPayments = order.getOrderPayments().stream()
                .map(OrderPaymentsDto::new)
                .collect(Collectors.toList());
    }
}
