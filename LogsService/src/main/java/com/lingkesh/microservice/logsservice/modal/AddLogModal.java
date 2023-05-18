package com.lingkesh.microservice.logsservice.modal;

public class AddLogModal {

    public String remark;
    public String logEvent;
    public String logUnixTimestamp;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLogEvent() {
        return logEvent;
    }

    public void setLogEvent(String logEvent) {
        this.logEvent = logEvent;
    }

    public String getLogUnixTimestamp() {
        return logUnixTimestamp;
    }

    public void setLogUnixTimestamp(String logUnixTimestamp) {
        this.logUnixTimestamp = logUnixTimestamp;
    }
}
