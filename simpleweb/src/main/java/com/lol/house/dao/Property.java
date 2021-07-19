package com.lol.house.dao;

import java.sql.Date;

public class Property {
    private String property_id;
    private int block_id;
    private int room_no;
    private Date check_in_date;
    private String unit_type;
    private int area;
    private String landlord_id;

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
