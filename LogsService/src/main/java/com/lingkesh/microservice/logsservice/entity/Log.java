package com.lingkesh.microservice.logsservice.entity;

import jakarta.persistence.*;

@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String log_user_id;
    private String event_id;
    @Column(nullable = false)
    private String remark;
    @Column(nullable = false)
    private Long created_date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLog_user_id() {
        return log_user_id;
    }

    public void setLog_user_id(String log_user_id) {
        this.log_user_id = log_user_id;
    }

    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Long created_date) {
        this.created_date = created_date;
    }
}
