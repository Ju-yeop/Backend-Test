package kr.co.kcp.backendcoding.work.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import kr.co.kcp.backendcoding.work.domain.enums.PaymentType;
import kr.co.kcp.backendcoding.work.global.util.RandomStringGenerator;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "order_reservations")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderReservation {
    @Id
    @Column(length = 9)
    private String reservationId;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 4)
    private PaymentType paymentType;

    @Column(length = 5)
    private String storeCode;

    private int orderAmount;

    private int discountAmount;

    private int paymentAmount;

    @PrePersist
    public void generateId() {
        this.reservationId = RandomStringGenerator.generateRandomString(9);
    }

    @Builder
    public OrderReservation(
            PaymentType paymentType,
            String storeCode,
            int orderAmount,
            int discountAmount,
            int paymentAmount) {
        this.paymentType = paymentType;
        this.storeCode = storeCode;
        this.orderAmount = orderAmount;
        this.discountAmount = discountAmount;
        this.paymentAmount = paymentAmount;
    }


}
