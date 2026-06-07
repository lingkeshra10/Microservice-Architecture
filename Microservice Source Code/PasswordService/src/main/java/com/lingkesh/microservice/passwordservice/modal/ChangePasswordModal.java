package com.lingkesh.microservice.passwordservice.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordModal {
    private long userId;
    private String username;
    private int oldPassword;
    private String newPassword;
}
