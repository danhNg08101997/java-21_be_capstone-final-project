package com.cybersoft.newbalanceproject.dto.request;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {
    private String senderName;
    private String receiverName;
    private String message;
    private String sender;
    private String create_at;
    private Status status;
}
