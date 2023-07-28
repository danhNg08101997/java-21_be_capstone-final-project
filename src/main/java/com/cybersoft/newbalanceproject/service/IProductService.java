package com.cybersoft.newbalanceproject.service;

import com.cybersoft.newbalanceproject.dto.request.ProductRequest;
import com.cybersoft.newbalanceproject.dto.response.BaseResponse;
import com.cybersoft.newbalanceproject.dto.response.ProductResponse;
import com.cybersoft.newbalanceproject.entity.ProductEntity;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface IProductService {
    List<ProductResponse> getAllProduct();
    boolean addProduct(ProductRequest product);
    BaseResponse deleteProduct(int id);
    BaseResponse editProduct(ProductRequest product);
}
