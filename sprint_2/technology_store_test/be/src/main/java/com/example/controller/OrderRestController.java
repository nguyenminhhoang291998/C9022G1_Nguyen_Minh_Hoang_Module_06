package com.example.controller;

import com.example.dto.IOrderDTO;
import com.example.model.Order;
import com.example.model.OrderDetail;
import com.example.model.Product;
import com.example.security_authentication.jwt.JwtFilter;
import com.example.security_authentication.jwt.JwtUtility;
import com.example.service.IOrderDetailService;
import com.example.service.IOrderService;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("api/customer")
@CrossOrigin
public class OrderRestController {

    @Autowired
    private IOrderService iOrderService;

    @Autowired
    private IProductService iProductService;
    @Autowired
    private IOrderDetailService iOrderDetailService;
    @Autowired
    private JwtUtility jwtUtility;

    @GetMapping("/cart")
    public ResponseEntity<?> getCart(HttpServletRequest request) {
        Long personId = getPersonIdFromToken(request);
        if (personId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<IOrderDTO> orderDTOList = iOrderService.getCart(personId);
        if (orderDTOList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(orderDTOList, HttpStatus.OK);
    }

    @GetMapping("/addProduct")
    public ResponseEntity<?> addProduct(HttpServletRequest request, @RequestParam Long productId, @RequestParam int quantity) {
        Long personId = getPersonIdFromToken(request);
        if (personId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<IOrderDTO> orderDTOList = iOrderService.getCart(personId);
        if (orderDTOList.isEmpty()) {
            iOrderService.createCart(personId, productId, quantity);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        OrderDetail orderDetail = iOrderDetailService.findByProductIdAndPersonId(productId, personId);
        if (orderDetail != null) {
            int quantityNew = orderDetail.getOrderedQuantity() + quantity;
            if(quantityNew > orderDetail.getProduct().getProductQuantity()) {
                return new ResponseEntity<>("Số lượng sản phẩm " + orderDetail.getProduct().getName() + " chỉ còn "
                        + orderDetail.getProduct().getProductQuantity(),HttpStatus.BAD_REQUEST);
            }
            iOrderService.changeQuantity(orderDetail.getId(), quantityNew);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            Order order = iOrderService.findByPersonId(personId);
            if (iOrderDetailService.addNewOrderDetail(new OrderDetail(quantity, new Product(productId), order))) {
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/changeQuantity")
    public ResponseEntity<?> changeQuantity(@RequestParam Long orderDetailId, @RequestParam int quantity) {
        boolean checkChangeQuantity = iOrderService.changeQuantity(orderDetailId, quantity);
        if (!checkChangeQuantity) {
            return new ResponseEntity<>("Đã có lỗi xảy ra!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteOrderDetail")
    public ResponseEntity<?> deleteOrderDetail(@RequestParam Long orderDetailId) {
        boolean checkDeleteOrderDetail = iOrderService.deleteOrderDetail(orderDetailId);
        if (!checkDeleteOrderDetail) {
            return new ResponseEntity<>("Đã có lỗi xảy ra!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/order-history-list")
    public ResponseEntity<?> getOrderHistoryList(HttpServletRequest request) {
        Long personId = getPersonIdFromToken(request);
        if (personId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<IOrderDTO> orderHistoryList = iOrderService.getOrderHistory(personId);
        if (orderHistoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(orderHistoryList, HttpStatus.OK);
    }

    @GetMapping("/order-history-detail")
    public ResponseEntity<?> getOrderHistoryDetail(HttpServletRequest request,@RequestParam Long orderId) {
        Long personId = getPersonIdFromToken(request);
        if (personId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<IOrderDTO> orderHistoryDetail = iOrderService.getOrderHistoryDetail(personId, orderId);
        if (orderHistoryDetail.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(orderHistoryDetail, HttpStatus.OK);
    }

    @Transactional
    @GetMapping("/payment")
    public ResponseEntity<?> payment(HttpServletRequest request) {
        Long personId = getPersonIdFromToken(request);
        if (personId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<IOrderDTO> orderDTOList = iOrderService.getCart(personId);
        // kiểm tra số lượng có hợp lệ không
        for (IOrderDTO order : orderDTOList) {
            if (order.getOrderedQuantity() == 0 || order.getOrderedQuantity() > order.getProductQuantity()) {
                return new ResponseEntity<>("Số lượng đã có thay đổi. Mời chọn lại.",HttpStatus.BAD_REQUEST);
            }
        }
        // thay đổi số lượng trong kho
        for (IOrderDTO order : orderDTOList) {
            iProductService.changeProductQuantity(order.getProductId(),order.getProductQuantity() - order.getOrderedQuantity());
        }
        if (iOrderService.paymentOrder(personId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    private Long getPersonIdFromToken(HttpServletRequest request) {
        String jwt = JwtFilter.parseJwt(request);
        if (jwt != null && jwtUtility.validateJwtToken(jwt)) {
            return jwtUtility.getIdFromJwtToken(jwt);
        }
        return null;
    }
}
