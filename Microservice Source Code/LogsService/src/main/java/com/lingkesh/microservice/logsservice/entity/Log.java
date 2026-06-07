package com.lingkesh.microservice.logsservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "brLogs")
public class Log {
    @Id
    private ObjectId id;
    private String logUserId;
    private int eventId;
    private String remark;
    private long created_date;
    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", logUserId='" + logUserId + '\'' +
                ", eventId=" + eventId +
                ", remark='" + remark + '\'' +
                ", created_date=" + created_date +
                '}';
    }
}
