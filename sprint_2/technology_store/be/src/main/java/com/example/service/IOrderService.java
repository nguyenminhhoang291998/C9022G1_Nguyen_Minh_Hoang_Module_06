package com.example.service;

import com.example.dto.IOrderDTO;

import java.util.List;

public interface IOrderService {
    List<IOrderDTO> getCart(Long personId);

    boolean changeQuantity(Long orderDetail,Long quantity);

    boolean deleteOrderDetail(Long orderDetailId);
}
