package com.example.service.impl;

import com.example.dto.IOrderDTO;
import com.example.repository.IOrderRepository;
import com.example.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository iOrderRepository;
    @Override
    public List<IOrderDTO> getCart(Long personId) {
        return iOrderRepository.getCart(personId);
    }

    @Override
    public boolean changeQuantity(Long orderDetail, Long quantity) {
        try {
            iOrderRepository.changeQuantity(orderDetail,quantity);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteOrderDetail(Long orderDetailId) {
        try {
            iOrderRepository.deleteOrderDetail(orderDetailId);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
