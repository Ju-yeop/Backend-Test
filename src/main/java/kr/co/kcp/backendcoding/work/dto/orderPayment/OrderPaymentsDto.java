package kr.co.kcp.backendcoding.work.dto.orderPayment;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import kr.co.kcp.backendcoding.work.domain.OrderPayment;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderPaymentsDto {
    @NotNull
    @Min(0)
    private int paymentId;

    @NotBlank
    @Size(max = 255)
    private String paymentMethod;

    @NotBlank
    @Size(max = 10)
    private String paymentDate;

    public OrderPaymentsDto(OrderPayment orderPayment) {
        this.paymentId = Math.toIntExact(orderPayment.getId());
        this.paymentMethod = orderPayment.getPaymentMethod();
        this.paymentDate = orderPayment.getPaymentDate().toString();
    }
}
