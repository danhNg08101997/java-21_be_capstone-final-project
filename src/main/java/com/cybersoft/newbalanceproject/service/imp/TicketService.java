package com.cybersoft.newbalanceproject.service.imp;

import com.cybersoft.newbalanceproject.dto.request.ChatMessage;
import com.cybersoft.newbalanceproject.dto.response.BaseResponse;
import com.cybersoft.newbalanceproject.entity.TicketEntitty;
import com.cybersoft.newbalanceproject.repository.GDVRepository;
import com.cybersoft.newbalanceproject.repository.TicketRepository;
import com.cybersoft.newbalanceproject.repository.TransactionRepository;
import com.cybersoft.newbalanceproject.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
@Service
public class TicketService implements ITicketService {
    @Autowired
    private  GDVRepository gDVRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @Override
    public List<TicketEntitty> getAllProduct() {
        return null;
    }

    @Override
    public TicketEntitty addTicket(ChatMessage chatMessage) {
        TicketEntitty ticketEntitty = new TicketEntitty();
        ticketEntitty.setGdvOfTicket(gDVRepository.findById(chatMessage.getGdv_id()).get());
        Date currentDate = new Date(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = formatter.format(currentDate);
        ticketEntitty.setCreate(Date.valueOf(formattedDate));
        ticketEntitty.setDelete(false);
        ticketEntitty.setTransaction(transactionRepository.findById(chatMessage.getTransactionId()).get());
        ticketEntitty.setMessage("1:"+"Tôi muốn tìm hiểu về dịch vụ "+chatMessage.getProductName()+"\n");
        TicketEntitty entity = ticketRepository.save(ticketEntitty);
        return entity;
    }

    @Override
    public BaseResponse deleteTicket(int id) {
        return null;
    }
}
