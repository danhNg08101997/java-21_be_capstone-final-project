package com.cybersoft.newbalanceproject.controller;

import com.cybersoft.newbalanceproject.dto.request.ProductRequest;
import com.cybersoft.newbalanceproject.dto.request.TransactionRequest;
import com.cybersoft.newbalanceproject.dto.response.BaseResponse;
import com.cybersoft.newbalanceproject.service.IProductService;
import com.cybersoft.newbalanceproject.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private ITransactionService transaction;
    @PostMapping("")
    public ResponseEntity<BaseResponse> getAllTransaction(){
        BaseResponse response = new BaseResponse();
        response.setMessage("Thành công");
        response.setStatusCode(200);
        response.setData(transaction.getAllTransaction());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<BaseResponse> createproduct(@RequestBody TransactionRequest transactionRequest){
        boolean issuccess = transaction.addTransaction(transactionRequest);
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
    public ResponseEntity<BaseResponse> deleteTransaction(@RequestParam int id){
        return new ResponseEntity<>(transaction.deleteTransaction(id),HttpStatus.OK);
    }
    @PostMapping("/edit")
    public ResponseEntity<BaseResponse>editTransaction(@RequestBody TransactionRequest request){
        return new ResponseEntity<>(transaction.editTransaction(request), HttpStatus.OK);
    }
}