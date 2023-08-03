package com.cybersoft.newbalanceproject.service;

import com.cybersoft.newbalanceproject.dto.request.ChatMessage;
import com.cybersoft.newbalanceproject.dto.request.ProductRequest;
import com.cybersoft.newbalanceproject.dto.response.BaseResponse;
import com.cybersoft.newbalanceproject.entity.ProductEntity;
import com.cybersoft.newbalanceproject.entity.TicketEntitty;

import java.util.List;

public interface ITicketService {
    List<TicketEntitty> getAllProduct();
    TicketEntitty addTicket(ChatMessage chatMessage);
    BaseResponse deleteTicket(int id);
}
