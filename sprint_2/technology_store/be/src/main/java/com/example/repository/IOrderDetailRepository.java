package com.example.repository;

import com.example.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDetailRepository extends JpaRepository<OrderDetail,Long> {
//    OrderDetail findByProductAndOrOrder(Long)
}
