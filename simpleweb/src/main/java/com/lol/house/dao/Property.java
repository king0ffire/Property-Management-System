package com.lol.house.dao;

import java.sql.Date;

public class Property {
    private String property_id; //房产编号
    private int block_id; //楼号
    private int room_no; //房号
    private Date check_in_date;  //入住时间
    private String unit_type;  //户型
    private int area;  //面积
    private String landlord_id; //业主

    public String getProperty_id() {
        return property_id;
    }

    public void setProperty_id(String property_id) {
        this.property_id = property_id;
    }

    public int getBlock_id() {
        return block_id;
    }

    public void setBlock_id(int block_id) {
        this.block_id = block_id;
    }

    public int getRoom_no() {
        return room_no;
    }

    public void setRoom_no(int room_no) {
        this.room_no = room_no;
    }

    public Date getCheck_in_date() {
        return check_in_date;
    }

    public void setCheck_in_date(Date check_in_date) {
        this.check_in_date = check_in_date;
    }

    public String getUnit_type() {
        return unit_type;
    }

    public void setUnit_type(String unit_type) {
        this.unit_type = unit_type;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getLandlord_id() {
        return landlord_id;
    }

    public void setLandlord_id(String landlord_id) {
        this.landlord_id = landlord_id;
    }
}
