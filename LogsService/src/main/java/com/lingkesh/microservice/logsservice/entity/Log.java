package com.lingkesh.microservice.logsservice.entity;

import jakarta.persistence.*;

@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String log_user_id;
    private int event_id;
    @Column(nullable = false)
    private String remark;
    @Column(nullable = false)
    private long created_date;

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

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public long getCreated_date(long currentTime) {
        return created_date;
    }

    public void setCreated_date(long created_date) {
        this.created_date = created_date;
    }
}
