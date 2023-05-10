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
    @Query(value = "   SELECT o.id AS id, \n" +
            "    o.date_purchase AS datePurchase, \n" +
            "    o.order_code AS orderCode,\n" +
            "    od.ordered_quantity AS orderedQuantity, \n" +
            "    p.name AS productName, \n" +
            "    p.id AS productId, \n" +
            "    p.product_quantity AS productQuantity, \n" +
            "    p.price AS productPrice,\n" +
            "    img.url AS url, \n" +
            "    od.id as orderDetailId, \n" +
            "     (SELECT SUM(od2.ordered_quantity)\n" +
            "     FROM order_detail od2\n" +
            "     JOIN product p2 ON od2.product_id = p2.id\n" +
            "     WHERE od2.order_id = o.id) AS totalQuantity, \n" +
            "    (SELECT SUM(od2.ordered_quantity * p2.price)\n" +
            "     FROM order_detail od2\n" +
            "     JOIN product p2 ON od2.product_id = p2.id\n" +
            "     WHERE od2.order_id = o.id) AS totalPrice\n" +
            "FROM orders o \n" +
            "JOIN person ps ON ps.id = o.person_id \n" +
            "JOIN order_detail od ON o.id = od.order_id\n" +
            "JOIN product p ON od.product_id = p.id\n" +
            "LEFT JOIN (\n" +
            "    SELECT product_id, url \n" +
            "    FROM image \n" +
            "    WHERE id IN (\n" +
            "        SELECT MIN(id) \n" +
            "        FROM image \n" +
            "        GROUP BY product_id\n" +
            "    )\n" +
            ") img ON img.product_id = p.id\n" +
            "WHERE is_paid = false and ps.id = ?1",nativeQuery = true)
    List<IOrderDTO> getCart(Long personId);

    @Modifying
    @Query(value = "UPDATE order_detail od\n" +
            "JOIN orders o ON od.order_id = o.id\n" +
            "SET od.ordered_quantity = ?2\n" +
            "WHERE od.id = ?1 AND o.is_paid = false",nativeQuery = true)
    void changeQuantity(Long orderDetail, int quantity);

    @Modifying
    @Query(value = "delete from order_detail where id = ?1", nativeQuery = true)
    void deleteOrderDetail(Long orderDetailId);

    @Query(value = "select * from orders where person_id = ?1 and is_paid = false",nativeQuery = true)
    Order findByPersonId(Long personId);

    @Modifying
    @Query(value = "update orders set is_paid = true where person_id = ?1",nativeQuery = true)
    void paymentOrder(Long personId);

    @Query(value = "   SELECT o.id AS id, \n" +
            "    o.date_purchase AS datePurchase, \n" +
            "    o.order_code AS orderCode,\n" +
            "    od.ordered_quantity AS orderedQuantity, \n" +
            "    p.name AS productName, \n" +
            "    p.id AS productId, \n" +
            "    p.product_quantity AS productQuantity, \n" +
            "    p.price AS productPrice,\n" +
            "    img.url AS url, \n" +
            "    od.id as orderDetailId, \n" +
            "     (SELECT SUM(od2.ordered_quantity)\n" +
            "     FROM order_detail od2\n" +
            "     JOIN product p2 ON od2.product_id = p2.id\n" +
            "     WHERE od2.order_id = o.id) AS totalQuantity, \n" +
            "    (SELECT SUM(od2.ordered_quantity * p2.price)\n" +
            "     FROM order_detail od2\n" +
            "     JOIN product p2 ON od2.product_id = p2.id\n" +
            "     WHERE od2.order_id = o.id) AS totalPrice\n" +
            "FROM orders o \n" +
            "JOIN person ps ON ps.id = o.person_id \n" +
            "JOIN order_detail od ON o.id = od.order_id\n" +
            "JOIN product p ON od.product_id = p.id\n" +
            "LEFT JOIN (\n" +
            "    SELECT product_id, url \n" +
            "    FROM image \n" +
            "    WHERE id IN (\n" +
            "        SELECT MIN(id) \n" +
            "        FROM image \n" +
            "        GROUP BY product_id\n" +
            "    )\n" +
            ") img ON img.product_id = p.id\n" +
            "WHERE is_paid = true and ps.id = ?1 group by o.id",nativeQuery = true)
    List<IOrderDTO> getOrderHistory(Long personId);

    @Query(value = "   SELECT o.id AS id, \n" +
            "    o.date_purchase AS datePurchase, \n" +
            "    o.order_code AS orderCode,\n" +
            "    od.ordered_quantity AS orderedQuantity, \n" +
            "    p.name AS productName, \n" +
            "    p.id AS productId, \n" +
            "    p.product_quantity AS productQuantity, \n" +
            "    p.price AS productPrice,\n" +
            "    img.url AS url, \n" +
            "    od.id as orderDetailId, \n" +
            "     (SELECT SUM(od2.ordered_quantity)\n" +
            "     FROM order_detail od2\n" +
            "     JOIN product p2 ON od2.product_id = p2.id\n" +
            "     WHERE od2.order_id = o.id) AS totalQuantity, \n" +
            "    (SELECT SUM(od2.ordered_quantity * p2.price)\n" +
            "     FROM order_detail od2\n" +
            "     JOIN product p2 ON od2.product_id = p2.id\n" +
            "     WHERE od2.order_id = o.id) AS totalPrice\n" +
            "FROM orders o \n" +
            "JOIN person ps ON ps.id = o.person_id \n" +
            "JOIN order_detail od ON o.id = od.order_id\n" +
            "JOIN product p ON od.product_id = p.id\n" +
            "LEFT JOIN (\n" +
            "    SELECT product_id, url \n" +
            "    FROM image \n" +
            "    WHERE id IN (\n" +
            "        SELECT MIN(id) \n" +
            "        FROM image \n" +
            "        GROUP BY product_id\n" +
            "    )\n" +
            ") img ON img.product_id = p.id\n" +
            "WHERE is_paid = true and ps.id = ?1 and o.id = ?2",nativeQuery = true)
    List<IOrderDTO> getOrderHistoryDetail(Long personId, Long orderId);
}
