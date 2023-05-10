package com.example.service;

import com.example.dto.IOrderDTO;
import com.example.model.Order;

import java.util.List;

public interface IOrderService {
    List<IOrderDTO> getCart(Long personId);

    boolean changeQuantity(Long orderDetail,int quantity);

    boolean deleteOrderDetail(Long orderDetailId);

    void createCart(Long personId, Long idProduct, int quantity);

    Order findByPersonId(Long personId);
    boolean paymentOrder(Long personId);

    List<IOrderDTO> getOrderHistory(Long personId);

    List<IOrderDTO> getOrderHistoryDetail(Long personId, Long orderId);
}
