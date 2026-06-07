package com.lingkesh.microservice.EmailService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="br_email_queue")
public class EmailQueue {
    @Id
    @Column(nullable = false)
    private String id;
    @Column(nullable = false)
    private int status;
    private String username;
    private String userEmail;
    @Column(nullable = false)
    private String email_info;
    private String retry_email_fail;
    @Column(nullable = false)
    private long created_date;
}
