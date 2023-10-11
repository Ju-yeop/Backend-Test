package kr.co.kcp.backendcoding.work.dto.orderReservation;

import static kr.co.kcp.backendcoding.work.global.response.error.dto.ErrorCode.METHOD_ARGUMENT_NOT_VALID;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import kr.co.kcp.backendcoding.work.domain.OrderReservation;
import kr.co.kcp.backendcoding.work.domain.enums.PaymentType;
import kr.co.kcp.backendcoding.work.global.response.error.exception.BusinessException;
import kr.co.kcp.backendcoding.work.global.util.annotation.EnumValid;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostOrderReservationReq {
    @EnumValid(enumClass = PaymentType.class)
    private PaymentType paymentType;

    @NotBlank
    @Size(max = 10)
    private String shopCode;

    @NotNull
    @Min(0)
    private int orderAmount;

    @NotNull
    private int discountAmount;

    @NotNull
    private int paymentAmount;

    public OrderReservation toEntity(){
        return OrderReservation.builder()
                .paymentType(paymentType)
                .storeCode(shopCode)
                .orderAmount(orderAmount)
                .discountAmount(discountAmount)
                .paymentAmount(paymentAmount)
                .build();
    }

    public void validateAmount() {
        if (this.orderAmount - this.discountAmount != this.paymentAmount) {
            throw new BusinessException(METHOD_ARGUMENT_NOT_VALID);
        }
    }
}
