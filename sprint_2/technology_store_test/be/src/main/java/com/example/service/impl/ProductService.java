package com.example.service.impl;

import com.example.dto.IProductDTO;
import com.example.model.Product;
import com.example.repository.IProductRepository;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Page<IProductDTO> findAll(Pageable pageable, String nameSearch, Long productTypeId, Long brandsId, boolean isSort) {
        if(productTypeId == 0 && brandsId == 0 && !isSort) {
            return iProductRepository.getAllByName(pageable, nameSearch);
        } else if(productTypeId == 0 && brandsId == 0) {
            return iProductRepository.getAllByNameAndSort(pageable, nameSearch);
        } else if(productTypeId == 0 && !isSort) {
            return iProductRepository.getAllByNameAndBrands(pageable, nameSearch, brandsId);
        } else if(productTypeId == 0) {
            return iProductRepository.getAllByNameAndBrandsAndSort(pageable, nameSearch, brandsId);
        }else if (brandsId == 0 && !isSort) {
            return iProductRepository.getAllByNameAndProductType(pageable, nameSearch, productTypeId);
        }else if (brandsId == 0) {
            return iProductRepository.getAllByNameAndProductTypeAndSort(pageable, nameSearch, productTypeId);
        } else if (!isSort) {
            return iProductRepository.getAllByNameAndProductTypeAndBrands(pageable, nameSearch, productTypeId, brandsId);
        }
        return iProductRepository.getAllByNameAndProductTypeAndBrandsAndSort(pageable, nameSearch, productTypeId, brandsId);
    }

    @Override
    public Product findProductById(Long productId) {
        return iProductRepository.findProductById(productId);
    }

    @Override
    public void changeProductQuantity(Long productId, int newProductQuantity) {
        iProductRepository.changeProductQuantity(productId,newProductQuantity);
    }
}
