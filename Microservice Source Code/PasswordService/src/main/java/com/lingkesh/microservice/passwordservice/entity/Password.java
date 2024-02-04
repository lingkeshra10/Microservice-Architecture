package com.lingkesh.microservice.passwordservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name="br_password")
public class Password {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long password_user_id;
    @Column(nullable = false)
    private int user_password;
    @Column(nullable = false)
    private Long created_date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getPassword_user_id() {
        return password_user_id;
    }

    public void setPassword_user_id(long password_user_id) {
        this.password_user_id = password_user_id;
    }

    public int getUser_password() {
        return user_password;
    }

    public void setUser_password(int user_password) {
        this.user_password = user_password;
    }

    public Long getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Long created_date) {
        this.created_date = created_date;
    }
}
