package com.fiveone.shopsmart.suadmin.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.Map;

@Getter
@AllArgsConstructor
public class OrderCountReportDto implements Serializable {
    public long order_count;
    public long order_amount;

    public OrderCountReportDto(Map<String, Object> result) {
        this.order_count = (result.get("order_count") == null) ? 0 : (long) result.get("order_count");
        this.order_amount = (result.get("order_amount") == null) ? 0 : (long) result.get("order_amount");
    }
}
