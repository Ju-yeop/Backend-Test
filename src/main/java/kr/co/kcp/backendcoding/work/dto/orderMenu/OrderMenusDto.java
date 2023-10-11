package kr.co.kcp.backendcoding.work.dto.orderMenu;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import kr.co.kcp.backendcoding.work.domain.OrderMenu;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderMenusDto {

    @NotBlank
    @Size(max = 255)
    private String productName;

    @NotNull
    @Min(0)
    private int price;

    public OrderMenusDto(OrderMenu orderMenu) {
        this.productName = orderMenu.getProductName();
        this.price = orderMenu.getPrice();
    }
}
