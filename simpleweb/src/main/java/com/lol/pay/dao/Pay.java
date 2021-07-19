package com.lol.pay.dao;

import lombok.Data;

import java.sql.Date;

@Data
public class Pay {
    private String pay_id;
    private String cost_id;
    private double pay_money;
    private Date pay_time;
    private String pay_remark;
}
