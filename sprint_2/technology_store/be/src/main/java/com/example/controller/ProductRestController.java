package com.example.controller;

import com.example.dto.IOrderDTO;
import com.example.dto.IProductDTO;
import com.example.dto.ProductDetail;
import com.example.model.Brands;
import com.example.model.Image;
import com.example.model.Product;
import com.example.model.ProductType;
import com.example.service.IBrandsService;
import com.example.service.IOrderService;
import com.example.service.IProductService;
import com.example.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/customer")
@CrossOrigin
public class ProductRestController {
    @Autowired
    private IProductService iProductService;
    @Autowired
    private IProductTypeService iProductTypeService;
    @Autowired
    private IBrandsService iBrandsService;

    @Autowired
    private IOrderService iOrderService;

    @GetMapping("/product/list")
    public ResponseEntity<?> getAllProduct(@RequestParam(required = false, defaultValue = "0") int page,
                                           @RequestParam(required = false, defaultValue = "0") Long productTypeId,
                                           @RequestParam(required = false, defaultValue = "0") Long brandsId,
                                           @RequestParam(required = false, defaultValue = "") String nameSearch) {
        Pageable pageable = PageRequest.of(page, 8);
        Page<IProductDTO> productPage = iProductService.findAll(pageable, nameSearch, productTypeId, brandsId);
        if (productPage.isEmpty()) {
            return new ResponseEntity<>("Không tìm thấy dữ liệu!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productPage, HttpStatus.OK);
    }

    @GetMapping("/productType/list")
    public ResponseEntity<?> getAllProductType() {
        List<ProductType> productTypeList = iProductTypeService.findAll();
        if (productTypeList.isEmpty()) {
            return new ResponseEntity<>("Không tìm thấy dữ liệu!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productTypeList, HttpStatus.OK);
    }

    @GetMapping("/brands/list")
    public ResponseEntity<?> getAllBrands() {
        List<Brands> brandsList = iBrandsService.findAll();
        if (brandsList.isEmpty()) {
            return new ResponseEntity<>("Không tìm thấy dữ liệu!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(brandsList, HttpStatus.OK);
    }

    @GetMapping("/cart")
    public ResponseEntity<?> getCart(@RequestParam Long id) {
        List<IOrderDTO> orderDTOList = iOrderService.getCart(id);
        if (orderDTOList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(orderDTOList, HttpStatus.OK);
    }

    @GetMapping("/changeQuantity")
    public ResponseEntity<?> changeQuantity(@RequestParam Long orderDetailId, @RequestParam Long quantity) {
        boolean checkChangeQuantity = iOrderService.changeQuantity(orderDetailId, quantity);
        if (!checkChangeQuantity) {
            return new ResponseEntity<>("Đã có lỗi xảy ra!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @GetMapping("/addProduct")
//    public ResponseEntity<?> addProduct(@RequestParam Long personId, @RequestParam Long idProduct) {
//        List<IOrderDTO> orderDTOList = iOrderService.getCart(personId);
//        if (orderDTOList.isEmpty()) {
//
//        }
//    }

    @DeleteMapping("/deleteOrderDetail")
    public ResponseEntity<?> deleteOrderDetail(@RequestParam Long orderDetailId) {
        boolean checkDeleteOrderDetail = iOrderService.deleteOrderDetail(orderDetailId);
        if (!checkDeleteOrderDetail) {
            return new ResponseEntity<>("Đã có lỗi xảy ra!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/detail")
    public ResponseEntity<?> detailProduct(@RequestParam Long productId) {
        Product product = iProductService.findProductById(productId);
        ProductDetail productDetail = new ProductDetail(product, new ArrayList<>(product.getImageSet()));
        if (productDetail == null) {
            return new ResponseEntity<>("Không tìm thấy dữ liệu!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productDetail, HttpStatus.OK);
    }

}
