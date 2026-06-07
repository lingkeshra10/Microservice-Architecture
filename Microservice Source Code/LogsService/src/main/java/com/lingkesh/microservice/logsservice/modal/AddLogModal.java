package com.lingkesh.microservice.logsservice.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddLogModal {
    public String remark;
    public String logEvent;
    public String logUnixTimestamp;
}
