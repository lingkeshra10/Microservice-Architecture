package com.lingkesh.microservice.EmailService.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailDetailsModal {
    private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;
}
