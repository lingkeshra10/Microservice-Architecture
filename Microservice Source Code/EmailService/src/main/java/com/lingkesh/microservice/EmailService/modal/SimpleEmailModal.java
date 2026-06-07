package com.lingkesh.microservice.EmailService.modal;

import lombok.*;

@Getter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimpleEmailModal {
    String userId;
    private String username;
    private String email;
    private String emailNotificationType;
}
