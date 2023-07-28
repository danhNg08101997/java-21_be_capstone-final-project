package com.cybersoft.newbalanceproject.service.imp;

import com.cybersoft.newbalanceproject.dto.request.ProductRequest;
import com.cybersoft.newbalanceproject.dto.request.TransactionRequest;
import com.cybersoft.newbalanceproject.dto.response.BaseResponse;
import com.cybersoft.newbalanceproject.dto.response.ProductResponse;
import com.cybersoft.newbalanceproject.dto.response.TransactionResponse;
import com.cybersoft.newbalanceproject.entity.ProductEntity;
import com.cybersoft.newbalanceproject.entity.TransactionEntity;
import com.cybersoft.newbalanceproject.repository.*;
import com.cybersoft.newbalanceproject.service.ITransactionService;
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
public class TransactionService implements ITransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private RedisTemplate redis;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private GDVRepository gDVRepository;
    @Autowired
    private StatusRepository statusRepository;

    @Override
    public List<TransactionResponse> getAllTransaction() {
        List<TransactionResponse> responseList = new ArrayList<>();
        if(redis.hasKey("listTransaction")){
//            Nếu như có thì lấy giá trị lưu trữ lên redis
            System.out.println("Có giá trị trên redis");
            String data = redis.opsForValue().get("listTransaction").toString();

            Type listType = new TypeToken<ArrayList<TransactionEntity>>(){}.getType();
            responseList = new Gson().fromJson(data, listType);

        }else {
            System.out.println("Không có giá trị trên redis");

            List<TransactionEntity> list = transactionRepository.findByIsDeleteFalse();

            for (TransactionEntity data: list) {
                TransactionResponse entity = new TransactionResponse();
                entity.setTransId(data.getTransId());
                entity.setCustomer(data.getCustomer());
                entity.setProduct(data.getProduct());
                entity.setStatus(data.getStatus());
                entity.setGdvOfTransaction(data.getGdvOfTransaction());
                entity.setStartTime(data.getStartTime());
                entity.setEndTime(data.getEndTime());
                responseList.add(entity);
            }
            Gson gson = new Gson();
            String data = gson.toJson(responseList);
            redis.opsForValue().set("listTransaction", data);
        }
        return responseList;
    }
    @Override
    public boolean addTransaction(TransactionRequest transaction) {
        boolean isSuccess = false;
        try {
            TransactionEntity entity = new TransactionEntity();
            entity.setCustomer(customerRepository.findById(transaction.getCustomerId()));
            entity.setProduct(productRepository.findById(transaction.getProductId()));
            entity.setGdvOfTransaction(gDVRepository.findById(transaction.getGdvId()));
            entity.setStatus(statusRepository.findById(transaction.getStatusId()));
            entity.setStartTime(transaction.getStart_time());
            entity.setEndTime(transaction.getEnd_time());
            entity.setDelete(false);
            // Thêm admin
            transactionRepository.save(entity);
            isSuccess = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        Gson gson = new Gson();
        redis.opsForValue().set("listTransaction",gson.toJson(transactionRepository.findByIsDeleteFalse()));
        return isSuccess;
    }

    @Override
    public BaseResponse deleteTransaction(int id) {
        BaseResponse baseResponse = new BaseResponse();
        int countDelete = transactionRepository.deleteTransaction(id);
        if (countDelete > 0){
            baseResponse.setStatusCode(HttpStatus.OK.value());
            baseResponse.setMessage("Xoá thành công");
            baseResponse.setData(countDelete);
        }else {
            baseResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            baseResponse.setMessage("Xoá thất bại");
        }
        Gson gson = new Gson();
        redis.opsForValue().set("listTransaction",gson.toJson(transactionRepository.findByIsDeleteFalse()));
        return baseResponse;
    }

    @Override
    public BaseResponse editTransaction(TransactionRequest transactionRequest) {
        BaseResponse response = new BaseResponse();
        TransactionEntity entity = new TransactionEntity();
        transactionRepository.getReferenceById(transactionRequest.getTransId());
        entity.setProduct(productRepository.findById(transactionRequest.getProductId()));
        entity.setCustomer(customerRepository.findById(transactionRequest.getCustomerId()));
        entity.setStatus(statusRepository.findById(transactionRequest.getGdvId()));
        entity.setGdvOfTransaction(gDVRepository.findById(transactionRequest.getGdvId()));
        entity.setStartTime(transactionRequest.getStart_time());
        entity.setEndTime(transactionRequest.getEnd_time());
        entity.setDelete(false);
        transactionRepository.save(entity);
        if(entity != null){
            response.setStatusCode(HttpStatus.OK.value());
            response.setMessage("Cập nhật thành công");
            response.setData(entity);
        }else {
            response.setStatusCode(HttpStatus.BAD_GATEWAY.value());
            response.setMessage("Cập nhật thất bại");
        }
        Gson gson = new Gson();
        redis.opsForValue().set("listTransaction",gson.toJson(transactionRepository.findByIsDeleteFalse()));
        return response;
    }
}
