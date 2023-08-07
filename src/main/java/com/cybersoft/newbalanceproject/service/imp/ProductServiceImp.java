package com.cybersoft.newbalanceproject.service.imp;

import com.cybersoft.newbalanceproject.dto.request.ProductRequest;
import com.cybersoft.newbalanceproject.dto.response.BaseResponse;
import com.cybersoft.newbalanceproject.entity.ProductEntity;
import com.cybersoft.newbalanceproject.repository.CategoryRepository;
import com.cybersoft.newbalanceproject.repository.ProductRepository;
import com.cybersoft.newbalanceproject.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImp implements IProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<ProductEntity> getAllProduct() {
        return productRepository.findByIsDeleteFalse();
    }
    @Override
    public boolean addProduct(ProductRequest product) {
        boolean isSuccess = false;
        try {
            ProductEntity entity = new ProductEntity();
            entity.setProductName(product.getProductName());
            entity.setProductDesc(product.getProductDesc());
            entity.setCategory(categoryRepository.findById(product.getCategoryId()).get());
            entity.setPath(product.getPath());
            entity.setDelete(false);
            int countUsername = productRepository.countByProductName(product.getProductName());
            if(countUsername > 0){
                return isSuccess;
            }
            productRepository.save(entity);
            isSuccess = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public BaseResponse deleteProduct(int id ) {
        BaseResponse baseResponse = new BaseResponse();
        int countDelete = productRepository.deleteProduct(id);
        if (countDelete > 0){
            baseResponse.setStatusCode(HttpStatus.OK.value());
            baseResponse.setMessage("Xoá thành công");
            baseResponse.setData(countDelete);
        }else {
            baseResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            baseResponse.setMessage("Xoá thất bại");
        }
        return baseResponse;
    }

    @Override
    public BaseResponse editProduct(ProductRequest product) {
        BaseResponse response = new BaseResponse();
        ProductEntity entity = new ProductEntity();
        productRepository.getReferenceById(product.getProductId());
        entity.setProductId(product.getProductId());
        entity.setProductName(product.getProductName());
        entity.setProductDesc(product.getProductDesc());
        entity.setCategory(categoryRepository.findById(product.getCategoryId()).get());
        entity.setDelete(false);
        productRepository.save(entity);
        if(entity != null){
            response.setStatusCode(HttpStatus.OK.value());
            response.setMessage("Cập nhật thành công");
            response.setData(entity);
        }else {
            response.setStatusCode(HttpStatus.BAD_GATEWAY.value());
            response.setMessage("Cập nhật thất bại");
        }
        return response;
    }
}
