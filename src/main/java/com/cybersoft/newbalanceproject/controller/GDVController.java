package com.cybersoft.newbalanceproject.controller;

import com.cybersoft.newbalanceproject.dto.request.GDVRequest;
import com.cybersoft.newbalanceproject.dto.response.BaseResponse;
import com.cybersoft.newbalanceproject.entity.GDVEntity;
import com.cybersoft.newbalanceproject.service.IGDVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gdv")
public class GDVController {
    @Autowired
    private IGDVService service;

    @PostMapping(value = "",consumes = "application/json", produces = "application/json")
    ResponseEntity<BaseResponse>getGDVs(){
        BaseResponse response = new BaseResponse();
        response.setData(this.service.getAll());
        response.setStatusCode(HttpStatus.OK.value());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping(value = "/create",consumes = "application/json", produces = "application/json")
    ResponseEntity<BaseResponse>createGDV(@RequestBody GDVRequest request){
        boolean isSuccess = service.addGDV(request);
        BaseResponse response = new BaseResponse();
        if(isSuccess) {
            response.setStatusCode(HttpStatus.OK.value());
            response.setMessage("Đăng ký thành công");
            response.setData(isSuccess);
        }else {
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            response.setMessage("Đăng ký thất bại - vì đã tồn tại username: " + request.getUsername() + " trong hệ thống");
            response.setData(isSuccess);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping(value = "/delete",consumes = "application/json", produces = "application/json")
    ResponseEntity<BaseResponse>deleteGDV(@RequestBody GDVRequest request){
        return new ResponseEntity<>(this.service.deleteGDV(request.getId()),HttpStatus.OK );
    }
    @PostMapping(value = "/edit",consumes = "application/json", produces = "application/json")
    ResponseEntity<BaseResponse>editGDV(@RequestBody GDVRequest request){
        return new ResponseEntity<>(this.service.editGDV(request), HttpStatus.OK);
    }
}
