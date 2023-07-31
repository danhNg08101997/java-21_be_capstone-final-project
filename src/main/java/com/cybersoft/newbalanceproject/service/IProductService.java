package com.cybersoft.newbalanceproject.service;

import com.cybersoft.newbalanceproject.dto.request.ProductRequest;
import com.cybersoft.newbalanceproject.dto.response.BaseResponse;
import com.cybersoft.newbalanceproject.entity.ProductEntity;

import java.util.List;

public interface IProductService {
    List<ProductEntity> getAllProduct();
    boolean addProduct(ProductRequest product);
    BaseResponse deleteProduct(int id);
    BaseResponse editProduct(ProductRequest product);
}
