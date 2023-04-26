package com.example.service.impl;

import com.example.model.OrderDetail;
import com.example.repository.IOrderDetailRepository;
import com.example.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService implements IOrderDetailService {

    @Autowired
    private IOrderDetailRepository iOrderDetailRepository;
    @Override
    public OrderDetail findByProductIdAndPersonId(Long productId, Long personId) {
        return iOrderDetailRepository.findByProductIdAndPersonId(productId,personId);
    }

    @Override
    public boolean addNewOrderDetail(OrderDetail orderDetail) {
        try {
            iOrderDetailRepository.save(orderDetail);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
