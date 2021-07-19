package com.lol.cost.dao;

import lombok.Data;

import java.sql.Date;

@Data
public class Cost {
    private String cost_id;
    private String cost_reason;
    private Date cost_time;
    private String owner_id;
    private double cost_total;
}
