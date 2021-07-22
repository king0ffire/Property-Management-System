package com.lol.statistics.community;

import lombok.Data;

@Data
public class Fee {
    private String cost_reason;
    private double cost_total;

    public Fee(String cost_reason, double cost_total) {
        this.cost_reason = cost_reason;
        this.cost_total = cost_total;
    }
}
