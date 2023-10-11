package kr.co.kcp.backendcoding.work.service;

import kr.co.kcp.backendcoding.work.domain.OrderReservation;
import kr.co.kcp.backendcoding.work.domain.enums.PaymentType;
import kr.co.kcp.backendcoding.work.dto.orderReservation.PostOrderReservationReq;
import kr.co.kcp.backendcoding.work.dto.orderReservation.PostOrderReservationRes;
import kr.co.kcp.backendcoding.work.repository.OrderReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderReservationServiceImpl implements OrderReservationService{

    private final OrderReservationRepository orderReservationRepository;

    @Override
    @Transactional
    public PostOrderReservationRes postOrderReservation(PostOrderReservationReq postOrderReservationReq) {
        OrderReservation order = orderReservationRepository
                .save(postOrderReservationReq.toEntity());

        String reservationId = order.getReservationId();
        sendNotification(order.getPaymentType(), reservationId);

        return new PostOrderReservationRes(reservationId);
    }

    @Override
    public void sendNotification(PaymentType paymentType, String reservationId) {
        System.out.printf("%s : %s 예약완료", paymentType, reservationId);
    }
}
