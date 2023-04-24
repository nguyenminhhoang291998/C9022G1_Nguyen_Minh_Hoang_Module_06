package com.example.repository;

import com.example.dto.IOrderDTO;
import com.example.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IOrderRepository extends JpaRepository<Order,Long> {
    @Query(value = "SELECT \n" +
            "    o.id AS id, \n" +
            "    o.date_purchase AS datePurchase, \n" +
            "    o.order_code AS orderCode,\n" +
            "    od.ordered_quantity AS orderedQuantity, \n" +
            "    p.name AS productName, \n" +
            "    p.price AS productPrice,\n" +
            "    (SELECT i.url FROM image i WHERE i.product_id = p.id LIMIT 1) AS url, \n" +
            "    od.id as orderDetailId,\n" +
            "    SUM(od.ordered_quantity * p.price) OVER (PARTITION BY ps.id) AS total_price\n" +
            "FROM orders o \n" +
            "JOIN person ps ON ps.id = o.person_id \n" +
            "JOIN order_detail od ON o.id = od.order_id\n" +
            "JOIN product p ON od.product_id = p.id\n" +
            "JOIN image i ON i.product_id = p.id \n" +
            "WHERE is_paid = false and ps.id = ?1",nativeQuery = true)
    List<IOrderDTO> getCart(Long personId);

    @Modifying
    @Query(value = "update order_detail set ordered_quantity = ?2 where id = ?1",nativeQuery = true)
    void changeQuantity(Long orderDetail, Long quantity);

    @Modifying
    @Query(value = "delete from order_detail where id = ?1", nativeQuery = true)
    void deleteOrderDetail(Long orderDetailId);
}