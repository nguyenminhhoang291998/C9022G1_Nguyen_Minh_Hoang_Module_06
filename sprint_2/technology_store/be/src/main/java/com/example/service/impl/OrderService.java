package com.example.service.impl;

import com.example.dto.IOrderDTO;
import com.example.model.Order;
import com.example.model.OrderDetail;
import com.example.model.Person;
import com.example.model.Product;
import com.example.repository.IOrderDetailRepository;
import com.example.repository.IOrderRepository;
import com.example.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository iOrderRepository;
    @Autowired
    private IOrderDetailRepository iOrderDetailRepository;
    @Override
    public List<IOrderDTO> getCart(Long personId) {
        return iOrderRepository.getCart(personId);
    }

    @Override
    public boolean changeQuantity(Long orderDetail, int quantity) {
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

    @Override
    public void createCart(Long personId, Long idProduct, int quantity) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);
        Person person = new Person(personId);
        Order order = new Order(dateString,person);
        iOrderRepository.save(order);
        iOrderDetailRepository.save(new OrderDetail(quantity,new Product(idProduct),order));
    }

    @Override
    public Order findByPersonId(Long personId) {
        return iOrderRepository.findByPersonId(personId);
    }

    @Override
    public boolean paymentOrder(Long personId) {
        if(findByPersonId(personId) != null){
            try {
                iOrderRepository.paymentOrder(personId);
                return true;
            }catch (Exception e) {
                return false;
            }
        }
      return false;
    }

    @Override
    public List<IOrderDTO> getOrderHistory(Long personId) {
        return iOrderRepository.getOrderHistory(personId);
    }

    @Override
    public List<IOrderDTO> getOrderHistoryDetail(Long personId, Long orderId) {
        return iOrderRepository.getOrderHistoryDetail(personId, orderId);
    }

}
