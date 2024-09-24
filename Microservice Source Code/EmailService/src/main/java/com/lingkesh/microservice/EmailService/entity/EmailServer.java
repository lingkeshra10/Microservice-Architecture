package com.lingkesh.microservice.EmailService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="br_email")
public class EmailServer implements Serializable {

    private static final long serialVersionUID = 1L;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getRequire_authentication() {
        return require_authentication;
    }

    public void setRequire_authentication(Integer require_authentication) {
        this.require_authentication = require_authentication;
    }

    public Integer getDebug_mode() {
        return debug_mode;
    }

    public void setDebug_mode(Integer debug_mode) {
        this.debug_mode = debug_mode;
    }

    public Integer getSsl_enable() {
        return ssl_enable;
    }

    public void setSsl_enable(Integer ssl_enable) {
        this.ssl_enable = ssl_enable;
    }

    public Integer getTls_enable() {
        return tls_enable;
    }

    public void setTls_enable(Integer tls_enable) {
        this.tls_enable = tls_enable;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }
}
