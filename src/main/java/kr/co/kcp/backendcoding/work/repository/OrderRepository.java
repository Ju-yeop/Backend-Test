package kr.co.kcp.backendcoding.work.repository;

import java.util.Optional;
import kr.co.kcp.backendcoding.work.domain.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends CrudRepository<Order, String> {

    @Query(value =
            "SELECT o FROM Order o " +
            "JOIN FETCH o.orderMenus om " +
            "WHERE o.orderId = :orderId")
    Optional<Order> findByOrderId(@Param("orderId") String orderId);
}
