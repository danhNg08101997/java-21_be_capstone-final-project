package com.cybersoft.newbalanceproject.service.imp;

import com.cybersoft.newbalanceproject.dto.request.CustomerRequest;
import com.cybersoft.newbalanceproject.dto.request.SignUpRequest;
import com.cybersoft.newbalanceproject.dto.response.BaseResponse;
import com.cybersoft.newbalanceproject.dto.response.CustomerRespone;
import com.cybersoft.newbalanceproject.entity.CategoryEntity;
import com.cybersoft.newbalanceproject.entity.CustomerEntity;
import com.cybersoft.newbalanceproject.repository.CustomerRepository;
import com.cybersoft.newbalanceproject.service.ICustomerService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImp implements ICustomerService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CustomerRepository repository;
    @Autowired
    private RedisTemplate redis;
    @Override
    public boolean addCustomer(SignUpRequest request) {
        boolean isSuccess = false;
        try {
            CustomerEntity customer = new CustomerEntity();
            customer.setUsername(request.getUsername());
            customer.setFullname(request.getFullname());
            customer.setPassword(passwordEncoder.encode(request.getPassword()));
            customer.setDelete(false);
            customer.setPriority(false);
            // Kiểm tra trùng
            int countUsername = repository.countByUsername(request.getUsername());
            if(countUsername > 0){
                return isSuccess;
            }
            // Thêm admin
            repository.save(customer);
            isSuccess = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        Gson gson = new Gson();
        redis.opsForValue().set("listCustomer",gson.toJson(repository.findByIsDeleteFalse()));
        return isSuccess;
    }

    @Override
    public List<CustomerRespone> getAllCustomers() {
        List<CustomerRespone> responseList = new ArrayList<>();
        if(redis.hasKey("listCustomer")){
//            Nếu như có thì lấy giá trị lưu trữ lên redis
            System.out.println("Có giá trị trên redis");
            String data = redis.opsForValue().get("listCustomer").toString();

            Type listType = new TypeToken<ArrayList<CustomerEntity>>(){}.getType();
            responseList = new Gson().fromJson(data, listType);

        }else {
            System.out.println("Không có giá trị trên redis");

            List<CustomerEntity> list = repository.findByIsDeleteFalse();

            for (CustomerEntity data: list) {
                CustomerRespone entity = new CustomerRespone();
                entity.setId(data.getCustomerId());
                entity.setFullname(data.getFullname());
                entity.setCustomer_name(data.getUsername());
                entity.setIs_priority(data.isPriority());
                responseList.add(entity);
            }
            Gson gson = new Gson();
            String data = gson.toJson(responseList);
            redis.opsForValue().set("listCustomer", data);
        }
        return responseList;
    }

    @Override
    public BaseResponse deleteCustomer(CustomerRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        int countDeleteCustomer = repository.deleteCustomer(request.getId());
        if(countDeleteCustomer > 0){
            baseResponse.setStatusCode(HttpStatus.OK.value());
            baseResponse.setMessage("Xoá thành công");
            baseResponse.setData(countDeleteCustomer);

        }else {
            baseResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            baseResponse.setMessage("Xoá thất bại");
            return baseResponse;
        }
        Gson gson = new Gson();
        redis.opsForValue().set("listCustomer",gson.toJson(repository.findByIsDeleteFalse()));
        return baseResponse;
    }

    @Override
    public BaseResponse editCustomer(CustomerRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        CustomerEntity customer = new CustomerEntity();
        repository.getReferenceById(request.getId());

        customer.setCustomerId(request.getId());
        customer.setUsername(request.getUsername());
        customer.setPassword(request.getPassword());
        customer.setFullname(request.getFullname());
        customer.setDelete(request.isDelete());
        customer.setPriority(request.isPriority());

        repository.save(customer);

        if(customer != null){
            baseResponse.setStatusCode(HttpStatus.OK.value());
            baseResponse.setMessage("Cập nhật thành công");
            baseResponse.setData(customer);
        }else {
            baseResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            baseResponse.setMessage("Cập nhật thất bại");
            return baseResponse;
        }
        Gson gson = new Gson();
        redis.opsForValue().set("listCustomer",gson.toJson(repository.findByIsDeleteFalse()));
        return baseResponse;
    }
}
