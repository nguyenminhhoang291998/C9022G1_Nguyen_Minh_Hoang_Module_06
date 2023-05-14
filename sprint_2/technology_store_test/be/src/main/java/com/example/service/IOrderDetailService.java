package com.example.service;

import com.example.model.OrderDetail;

public interface IOrderDetailService {
    OrderDetail findByProductIdAndPersonId(Long productId, Long personId);

    boolean addNewOrderDetail(OrderDetail orderDetail);
}
