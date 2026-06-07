package com.lingkesh.microservice.userservice.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterPasswordModal {
    private long userId;
    private String username;
    private int newPassword;
}
