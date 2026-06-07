package com.lingkesh.microservice.EmailService.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailAttachmentModal {
    String userId;
    private String username;
    private String email;
    private String emailNotificationType;
    private String attachment;
}
