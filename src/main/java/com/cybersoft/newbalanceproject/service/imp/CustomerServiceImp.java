package com.cybersoft.newbalanceproject.service.imp;

import com.cybersoft.newbalanceproject.dto.request.SignUpRequest;
import com.cybersoft.newbalanceproject.dto.response.BaseResponse;
import com.cybersoft.newbalanceproject.dto.response.CategoryResponse;
import com.cybersoft.newbalanceproject.dto.response.CustomerRespone;
import com.cybersoft.newbalanceproject.entity.CustomerEntity;
import com.cybersoft.newbalanceproject.repository.CustomerRepository;
import com.cybersoft.newbalanceproject.service.ICustomerService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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
    private RedisTemplate redis;
    @Autowired
    private CustomerRepository repository;
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
            if(countUsername>0){
                return isSuccess;
            }
            // Thêm admin
            repository.save(customer);
            isSuccess = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public List<CustomerRespone> findAllByIsNotDelete() {
        List<CustomerRespone> respones = new ArrayList<>();
        if(redis.hasKey("listCustomer")){
//            Nếu như có thì lấy giá trị lưu trữ lên redis
            System.out.println("Có giá trị trên redis");
            String data = redis.opsForValue().get("listCustomer").toString();

            Type listType = new TypeToken<ArrayList<CustomerRespone>>(){}.getType();
            respones = new Gson().fromJson(data, listType);

        }else {
            System.out.println("Không có giá trị trên redis");
            List<CustomerEntity> list = repository.findAllByIsNotDelete();

            for (CustomerEntity data: list) {
                CustomerRespone customerRespone = new CustomerRespone();
                customerRespone.setId(data.getCustomerId());
                customerRespone.setCustomer_name(data.getUsername());
                customerRespone.setIs_priority(data.isPriority());
                customerRespone.setFullname(data.getFullname());
                respones.add(customerRespone);
            }
            Gson gson = new Gson();
            String data = gson.toJson(respones);

            redis.opsForValue().set("listCustomer", data);
        }
        return respones;
    }
    @Override
    public BaseResponse deleteCustomer(int id){
        BaseResponse response = new BaseResponse();
        repository.setIsdeleteCustomer(id);

            response.setMessage("Xóa Thành Công");
            response.setStatusCode(200);
            response.setData(true);

        return response;
    }
}
