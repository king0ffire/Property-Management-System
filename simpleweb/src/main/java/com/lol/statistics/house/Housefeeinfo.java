package com.lol.statistics.house;

import lombok.Data;

import java.sql.Date;

@Data
public class Housefeeinfo {
    private String property_id; //房产编号
    private int block_id; //楼宇号
    private int room_no; //房号
    private Date check_in_date;  //验收时间
    private String unit_type;  //户型
    private int area;  //面积
    private String owner_name; //业主
    private String cost_reason;  //费用类型
    private Date cost_time; //费用产生时间
    private double cost_total; //费用总和
    private double pay_money; //已支付总和
    private Date pay_time; //支付时间
    private String pay_remark; //支付备注

    public Housefeeinfo(String property_id, int block_id, int room_no, Date check_in_date, String unit_type, int area
            , String owner_name, String cost_reason, Date cost_time, double cost_total, double pay_money,
                        Date pay_time, String pay_remark) {
        this.property_id = property_id;
        this.block_id = block_id;
        this.room_no = room_no;
        this.check_in_date = check_in_date;
        this.unit_type = unit_type;
        this.area = area;
        this.owner_name = owner_name;
        this.cost_reason = cost_reason;
        this.cost_time = cost_time;
        this.cost_total = cost_total;
        this.pay_money = pay_money;
        this.pay_time = pay_time;
        this.pay_remark = pay_remark;
    }
}
