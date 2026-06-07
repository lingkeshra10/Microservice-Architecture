package com.lingkesh.microservice.EmailService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;


@Entity
@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="br_email")
public class EmailServer{
    @Id
    @Column(nullable = false)
    private String id;
    @Column(nullable = false)
    private String host;
    private Integer port;
    private String sender;
    private String username;
    private String password;
    private Integer priority;
    private Integer require_authentication;
    private Integer debug_mode;
    private Integer ssl_enable;
    private Integer tls_enable;
    private Integer enable;
}
