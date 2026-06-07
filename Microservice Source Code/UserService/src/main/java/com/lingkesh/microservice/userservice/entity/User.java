package com.lingkesh.microservice.userservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
}
