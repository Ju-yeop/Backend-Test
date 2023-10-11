package kr.co.kcp.backendcoding.work.dto.orderReservation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PostOrderReservationRes {
    @NotBlank
    @Size(max = 9)
    private String reservationId;
}
