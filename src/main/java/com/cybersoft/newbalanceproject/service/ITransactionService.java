package com.cybersoft.newbalanceproject.service;

import com.cybersoft.newbalanceproject.dto.request.TransactionRequest;
import com.cybersoft.newbalanceproject.dto.response.BaseResponse;
import com.cybersoft.newbalanceproject.entity.TransactionEntity;

import java.util.List;

public interface ITransactionService {
    List<TransactionEntity> getAllTransaction();
    TransactionEntity addTransaction(TransactionRequest transactionRequest);
    BaseResponse deleteTransaction(int id);
    BaseResponse editTransaction(TransactionRequest transactionRequest);
}
