package com.example.service;

import com.example.dto.IOrderDTO;
import com.example.model.Order;

import java.util.List;

public interface IOrderService {
    List<IOrderDTO> getCart(Long personId);

    boolean changeQuantity(Long orderDetail,int quantity);

    boolean deleteOrderDetail(Long orderDetailId);

    void createCart(Long personId, Long idProduct);

    Order findByPersonId(Long personId);
}
