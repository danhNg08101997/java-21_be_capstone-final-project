package com.cybersoft.newbalanceproject.controller;

import com.cybersoft.newbalanceproject.dto.request.ChatMessage;
import com.cybersoft.newbalanceproject.dto.request.TransactionRequest;
import com.cybersoft.newbalanceproject.dto.response.GDVRespone;
import com.cybersoft.newbalanceproject.entity.TransactionEntity;
import com.cybersoft.newbalanceproject.service.IGDVService;
import com.cybersoft.newbalanceproject.service.IGdvSupportProduct;
import com.cybersoft.newbalanceproject.service.ITicketService;
import com.cybersoft.newbalanceproject.service.ITransactionService;
import com.cybersoft.newbalanceproject.utils.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

@Controller
public class ChatController {
    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private IGdvSupportProduct supportProduct;
    @Autowired
    private IGDVService gdvService;
    @Autowired
    private ITransactionService transactionService;
    @Autowired
    private ITicketService ticketService;
    @MessageMapping("/private-message")
    public ChatMessage receivePrivateMessage(@Payload ChatMessage chatMessage) {
        if (String.valueOf(jwtHelper.decodeToken(chatMessage.getToken()).getSubject()).equals("ROLE_CUSTOMER")){
            GDVRespone gdv = supportProduct.findSupportProduct(chatMessage.getProduct());
            chatMessage.setGdv_id(gdv.getId());
            TransactionRequest transaction = new TransactionRequest();
            transaction.setGdvId(gdv.getId());
            transaction.setStatusId(1);
            Date currentDate = new Date(System.currentTimeMillis());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = formatter.format(currentDate);
            transaction.setStart_time(Date.valueOf(formattedDate));
            transaction.setProductId(chatMessage.getProduct());
            transaction.setCustomerId(chatMessage.getCustomerId());
            TransactionEntity transactionEntity = transactionService.addTransaction(transaction);
            chatMessage.setTransactionId(transactionEntity.getTransId());
            boolean update_Success = gdvService.updateAvailable(gdv.getId());
            if (update_Success) {
                ticketService.addTicket(chatMessage);
                simpMessagingTemplate.convertAndSendToUser(gdv.getGdvName(), "/private", chatMessage);
            }
        }
        return chatMessage;
    }
}
