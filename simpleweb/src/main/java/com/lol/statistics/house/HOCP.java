package com.lol.statistics.house;

import lombok.Data;

import java.sql.Date;

@Data
public class HOCP {
    private String property_id; //房产编号
    private int block_id; //楼号
    private int room_no; //房号
    private Date check_in_date;  //入住时间
    private String unit_type;  //户型
    private int area;  //面积
    private String landlord_id; //业主
    private String owner_id;
    private String owner_name;
    private String owner_gender;
    private String owner_hometown;
    private String owner_phone;
    private String cost_id;
    private String cost_reason;
    private Date cost_time;
    //private String owner_id;
    private double cost_total;
    private String pay_id;
    //private String cost_id;
    private double pay_money;
    private Date pay_time;
    private String pay_remark;

    public HOCP(String property_id, int block_id, int room_no, Date check_in_date, String unit_type, int area,
                String landlord_id, String owner_id, String owner_name, String owner_gender, String owner_hometown,
                String owner_phone, String cost_id, String cost_reason, Date cost_time, double cost_total,
                String pay_id, double pay_money, Date pay_time, String pay_remark) {
        this.property_id = property_id;
        this.block_id = block_id;
        this.room_no = room_no;
        this.check_in_date = check_in_date;
        this.unit_type = unit_type;
        this.area = area;
        this.landlord_id = landlord_id;
        this.owner_id = owner_id;
        this.owner_name = owner_name;
        this.owner_gender = owner_gender;
        this.owner_hometown = owner_hometown;
        this.owner_phone = owner_phone;
        this.cost_id = cost_id;
        this.cost_reason = cost_reason;
        this.cost_time = cost_time;
        this.cost_total = cost_total;
        this.pay_id = pay_id;
        this.pay_money = pay_money;
        this.pay_time = pay_time;
        this.pay_remark = pay_remark;
    }
}
