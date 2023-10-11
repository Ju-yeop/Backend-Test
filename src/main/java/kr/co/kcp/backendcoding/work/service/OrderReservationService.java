package kr.co.kcp.backendcoding.work.service;

import kr.co.kcp.backendcoding.work.domain.enums.PaymentType;
import kr.co.kcp.backendcoding.work.dto.orderReservation.PostOrderReservationReq;
import kr.co.kcp.backendcoding.work.dto.orderReservation.PostOrderReservationRes;

public interface OrderReservationService {
    PostOrderReservationRes postOrderReservation(PostOrderReservationReq postOrderReservationReq);

    void sendNotification(PaymentType paymentType, String reservationId);

}
