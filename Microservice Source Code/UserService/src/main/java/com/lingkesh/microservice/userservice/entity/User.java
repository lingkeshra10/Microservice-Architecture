package com.lingkesh.microservice.userservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name="br_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String user_phone_number;
    private Integer status;
    @Column(nullable = false)
    private String unique_id;
    @Column(nullable = false)
    private String application_id;
    @Column(nullable = false)
    private int encryptPassword;
    @Column(nullable = false)
    private long created_date;
    private long updated_date;
    private long deleted_date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUser_phone_number() {
        return user_phone_number;
    }

    public void setUser_phone_number(String user_phone_number) {
        this.user_phone_number = user_phone_number;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(String unique_id) {
        this.unique_id = unique_id;
    }

    public String getApplication_id() {
        return application_id;
    }

    public void setApplication_id(String application_id) {
        this.application_id = application_id;
    }

    public int getEncryptPassword() {
        return encryptPassword;
    }

    public void setEncryptPassword(int encryptPassword) {
        this.encryptPassword = encryptPassword;
    }

    public long getCreated_date() {
        return created_date;
    }

    public void setCreated_date(long created_date) {
        this.created_date = created_date;
    }

    public long getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(long updated_date) {
        this.updated_date = updated_date;
    }

    public long getDeleted_date() {
        return deleted_date;
    }

    public void setDeleted_date(long deleted_date) {
        this.deleted_date = deleted_date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", user_phone_number='" + user_phone_number + '\'' +
                ", status=" + status +
                ", unique_id='" + unique_id + '\'' +
                ", application_id='" + application_id + '\'' +
                ", encryptPassword=" + encryptPassword +
                ", created_date=" + created_date +
                ", updated_date=" + updated_date +
                ", deleted_date=" + deleted_date +
                '}';
    }
}
