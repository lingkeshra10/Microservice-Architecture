package com.lingkesh.microservice.passwordservice.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterPasswordModal {
    private Long userId;
    private String username;
    private int newPassword;
}
