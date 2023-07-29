package com.cybersoft.newbalanceproject.service.imp;

import com.cybersoft.newbalanceproject.dto.request.ProductRequest;
import com.cybersoft.newbalanceproject.dto.response.BaseResponse;
import com.cybersoft.newbalanceproject.dto.response.ProductResponse;
import com.cybersoft.newbalanceproject.entity.ProductEntity;
import com.cybersoft.newbalanceproject.repository.CategoryRepository;
import com.cybersoft.newbalanceproject.repository.ProductRepository;
import com.cybersoft.newbalanceproject.service.IProductService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImp implements IProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private RedisTemplate redis;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<ProductResponse> getAllProduct() {
        List<ProductResponse> responseList = new ArrayList<>();
        if(redis.hasKey("listProduct")){
//            Nếu như có thì lấy giá trị lưu trữ lên redis
            System.out.println("Có giá trị trên redis");
            String data = redis.opsForValue().get("listProduct").toString();

            Type listType = new TypeToken<ArrayList<ProductEntity>>(){}.getType();
            responseList = new Gson().fromJson(data, listType);

        }else {
            System.out.println("Không có giá trị trên redis");

            List<ProductEntity> list = productRepository.findByIsDeleteFalse();

            for (ProductEntity data: list) {
                ProductResponse entity = new ProductResponse();
                entity.setProductId(data.getProductId());
                entity.setProduct_name(data.getProductName());
                entity.setProduct_desc(data.getProductDesc());
                entity.setCategoryId(data.getCategory());
                responseList.add(entity);
            }
            Gson gson = new Gson();
            String data = gson.toJson(responseList);
            redis.opsForValue().set("listProduct", data);
        }
        return responseList;
    }
    @Override
    public boolean addProduct(ProductRequest product) {
        boolean isSuccess = false;
        try {
            ProductEntity entity = new ProductEntity();
            entity.setProductName(product.getProduct_name());
            entity.setProductDesc(product.getProduct_desc());
            entity.setCategory(categoryRepository.findById(product.getCategoryId()).get());
            entity.setDelete(false);
            // Kiểm tra trùng
            int countUsername = productRepository.countByProductName(product.getProduct_name());
            if(countUsername > 0){
                return isSuccess;
            }
            // Thêm admin
            productRepository.save(entity);
            isSuccess = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        Gson gson = new Gson();
        redis.opsForValue().set("listProduct",gson.toJson(productRepository.findByIsDeleteFalse()));
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
        Gson gson = new Gson();
        redis.opsForValue().set("listProduct",gson.toJson(productRepository.findByIsDeleteFalse()));
        return baseResponse;
    }

    @Override
    public BaseResponse editProduct(ProductRequest product) {
        BaseResponse response = new BaseResponse();
        ProductEntity entity = new ProductEntity();
        productRepository.getReferenceById(product.getProductId());
        entity.setProductId(product.getProductId());
        entity.setProductName(product.getProduct_name());
        entity.setProductDesc(product.getProduct_desc());
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
        Gson gson = new Gson();
        redis.opsForValue().set("listProduct",gson.toJson(productRepository.findByIsDeleteFalse()));
        return response;
    }
}
