package com.lingkesh.microservice.EmailService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getEmail_info() {
        return email_info;
    }

    public void setEmail_info(String email_info) {
        this.email_info = email_info;
    }

    public String getRetry_email_fail() {
        return retry_email_fail;
    }

    public void setRetry_email_fail(String retry_email_fail) {
        this.retry_email_fail = retry_email_fail;
    }

    public long getCreated_date() {
        return created_date;
    }

    public void setCreated_date(long created_date) {
        this.created_date = created_date;
    }
}
