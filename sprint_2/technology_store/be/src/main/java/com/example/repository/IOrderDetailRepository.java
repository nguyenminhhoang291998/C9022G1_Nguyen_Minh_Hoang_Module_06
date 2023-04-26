package com.example.repository;

import com.example.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IOrderDetailRepository extends JpaRepository<OrderDetail,Long> {
//    OrderDetail findByProductAndOrOrder(Long)


    @Query(value = "select od.* from order_detail od join orders o on od.order_id = o.id where od.product_id = ?1 and o.person_id = ?2 and o.is_paid = false",nativeQuery = true)
    OrderDetail findByProductIdAndPersonId(Long productId, Long personId);
}
