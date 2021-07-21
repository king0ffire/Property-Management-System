package com.lol.statistics.owner;

import lombok.Data;

import java.sql.Date;

@Data
public class OH {
    private String owner_id;
    private String owner_name;
    private String owner_gender;
    private String owner_hometown;
    private String owner_phone;
    private String property_id;
    private int block_id;
    private int room_no;
    private Date check_in_date;
    private String unit_type;
    private int area;
    private String landlord_id;

    public OH(String owner_id, String owner_name, String owner_gender, String owner_hometown, String owner_phone, String property_id, int block_id, int room_no, Date check_in_date, String unit_type, int area, String landlord_id) {
        this.owner_id = owner_id;
        this.owner_name = owner_name;
        this.owner_gender = owner_gender;
        this.owner_hometown = owner_hometown;
        this.owner_phone = owner_phone;
        this.property_id = property_id;
        this.block_id = block_id;
        this.room_no = room_no;
        this.check_in_date = check_in_date;
        this.unit_type = unit_type;
        this.area = area;
        this.landlord_id = landlord_id;
    }
}
