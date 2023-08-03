package com.cybersoft.newbalanceproject.dto.request;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {
    private String token;
    private int gdv_id;
    private int customerId;
    private int transactionId;
    private String senderName;
    private String receiverName;
    private int product;
    private String productName;
    private String message;
}
