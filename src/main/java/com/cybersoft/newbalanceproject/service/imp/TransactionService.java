package com.cybersoft.newbalanceproject.service.imp;

import com.cybersoft.newbalanceproject.dto.request.TransactionRequest;
import com.cybersoft.newbalanceproject.dto.response.BaseResponse;
import com.cybersoft.newbalanceproject.entity.*;
import com.cybersoft.newbalanceproject.repository.*;
import com.cybersoft.newbalanceproject.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService implements ITransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private GDVRepository gDVRepository;
    @Autowired
    private StatusRepository statusRepository;

    @Override
    public List<TransactionEntity> getAllTransaction() {
        return transactionRepository.findByIsDeleteFalse();
    }
    @Override
    public boolean addTransaction(TransactionRequest transaction) {
        boolean isSuccess = false;
        try {
            TransactionEntity entity = new TransactionEntity();
            Optional<CustomerEntity> customerOpt = customerRepository.findById(transaction.getCustomerId());
            Optional<GDVEntity> gdvOpt = gDVRepository.findById(transaction.getGdvId());
            Optional<ProductEntity> productOpt = productRepository.findById(transaction.getProductId());
            Optional<StatusEntity> statusOpt = statusRepository.findById(transaction.getStatusId());
            entity.setCustomer(customerOpt.get());
            entity.setGdvOfTransaction(gdvOpt.get());
            entity.setProduct(productOpt.get());
            entity.setStatus(statusOpt.get());
            entity.setStartTime(transaction.getStart_time());
            entity.setEndTime(transaction.getEnd_time());
            entity.setDelete(false);
            // Thêm transaction
            transactionRepository.save(entity);
            isSuccess = true;
        }catch (Exception e){
            e.printStackTrace();
        }
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
        return baseResponse;
    }

    @Override
    public BaseResponse editTransaction(TransactionRequest transactionRequest) {
        BaseResponse response = new BaseResponse();
        TransactionEntity entity = new TransactionEntity();
        transactionRepository.getReferenceById(transactionRequest.getTransId());
        entity.setProduct(productRepository.findById(transactionRequest.getProductId()).get());
        entity.setCustomer(customerRepository.findById(transactionRequest.getCustomerId()).get());
        entity.setStatus(statusRepository.findById(transactionRequest.getGdvId()).get());
        entity.setGdvOfTransaction(gDVRepository.findById(transactionRequest.getGdvId()).get());
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
        return response;
    }
}
