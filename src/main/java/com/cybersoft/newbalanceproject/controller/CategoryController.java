package com.cybersoft.newbalanceproject.controller;

import com.cybersoft.newbalanceproject.dto.request.CategoryRequest;
import com.cybersoft.newbalanceproject.dto.response.BaseResponse;
import com.cybersoft.newbalanceproject.entity.CategoryEntity;
import com.cybersoft.newbalanceproject.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = "https://localhost:4200")
public class CategoryController {
    @Autowired
        private ICategoryService service;

        @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public ResponseEntity<BaseResponse> getAllCategories(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("Lấy danh mục thành công");
        baseResponse.setStatusCode(HttpStatus.OK.value());
        baseResponse.setData(service.getAllCategories());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

        @PostMapping (value = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<BaseResponse> create(@RequestBody CategoryRequest request){
        boolean isSuccess = service.addCategory(request);
        BaseResponse response = new BaseResponse();
        if(isSuccess){
            response.setStatusCode(HttpStatus.OK.value());
            response.setMessage("Tạo mới danh mục thành công");
            response.setData(isSuccess);
        }else {
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            response.setMessage("Tạo mới danh mục thất bại");
            response.setData(isSuccess);
        }

            return new ResponseEntity<>(response,HttpStatus.OK);
        }

        @PostMapping(value = "/delete", consumes = "application/json", produces = "application/json")
    public ResponseEntity<BaseResponse>delete(@RequestBody CategoryRequest request){
            return new ResponseEntity<>(service.deleteCategory(request),HttpStatus.OK);
        }
        @PostMapping(value = "/edit", consumes = "application/json", produces = "application/json")
    public ResponseEntity<BaseResponse>edit(@RequestBody CategoryRequest request){
            return new ResponseEntity<>(service.editCategory(request), HttpStatus.OK);
        }
}
