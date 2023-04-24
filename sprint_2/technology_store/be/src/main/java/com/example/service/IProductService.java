package com.example.service;

import com.example.dto.IProductDTO;
import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<IProductDTO> findAll(Pageable pageable, String nameSearch, Long productTypeId, Long brandsId);

    Product findProductById(Long productId);
}
