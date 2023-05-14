package com.example.controller;

import com.example.dto.IProductDTO;
import com.example.dto.ProductDetail;
import com.example.model.*;
import com.example.service.*;
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

    @GetMapping("/product/list")
    public ResponseEntity<?> getAllProduct(@RequestParam(required = false, defaultValue = "0") int page,
                                           @RequestParam(required = false, defaultValue = "0") Long productTypeId,
                                           @RequestParam(required = false, defaultValue = "0") Long brandsId,
                                           @RequestParam(required = false, defaultValue = "") String nameSearch,
                                           @RequestParam(required = false, defaultValue = "false") boolean isSort) {
        Pageable pageable = PageRequest.of(page, 8);
        Page<IProductDTO> productPage = iProductService.findAll(pageable, nameSearch, productTypeId, brandsId, isSort);
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

    @GetMapping("product/detail")
    public ResponseEntity<?> detailProduct(@RequestParam Long productId) {
        Product product = iProductService.findProductById(productId);
        ProductDetail productDetail = new ProductDetail(product, new ArrayList<>(product.getImageSet()));
        if (productDetail == null) {
            return new ResponseEntity<>("Không tìm thấy dữ liệu!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productDetail, HttpStatus.OK);
    }

}
