package com.cybersoft.newbalanceproject.controller;

import com.cybersoft.newbalanceproject.dto.request.ProductRequest;
import com.cybersoft.newbalanceproject.dto.response.BaseResponse;
import com.cybersoft.newbalanceproject.service.IProductService;
import com.cybersoft.newbalanceproject.service.imp.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TransactionService transactionService;
    @PostMapping("")
    public ResponseEntity<BaseResponse> getAllproduct(){
        BaseResponse response = new BaseResponse();
        response.setMessage("Thành công");
        response.setStatusCode(200);
        response.setData(transactionService.getAllProduct());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<BaseResponse> createproduct(@RequestBody ProductRequest productRequest){
        boolean issuccess = productService.addProduct(productRequest);
        BaseResponse response = new BaseResponse();
        if(issuccess){
            response.setData(true);
            response.setMessage("Thêm Thành Công");
            response.setStatusCode(200);
        }else{
            response.setData(false);
            response.setMessage("Thêm Thất Bại");
            response.setStatusCode(400);
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PostMapping("/delete")
    public ResponseEntity<BaseResponse> deleteProduct(@RequestParam int id){
        return new ResponseEntity<>(productService.deleteProduct(id),HttpStatus.OK);
    }
    @PostMapping("/edit")
    public ResponseEntity<BaseResponse>edit(@RequestBody ProductRequest request){
        return new ResponseEntity<>(productService.editProduct(request), HttpStatus.OK);
    }
}
