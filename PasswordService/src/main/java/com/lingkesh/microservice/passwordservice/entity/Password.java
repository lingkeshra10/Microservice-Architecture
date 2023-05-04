package com.lingkesh.microservice.passwordservice.entity;

import jakarta.persistence.*;

@Entity
public class Password {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password_user_id;
    @Column(nullable = false)
    private String user_password;
    @Column(nullable = false)
    private Long created_date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword_user_id() {
        return password_user_id;
    }

    public void setPassword_user_id(String password_user_id) {
        this.password_user_id = password_user_id;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Long getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Long created_date) {
        this.created_date = created_date;
    }
}
