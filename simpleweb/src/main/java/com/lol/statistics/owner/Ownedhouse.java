package com.lol.statistics.owner;

import lombok.Data;

import java.sql.Date;

@Data
public class Ownedhouse {
    private String owner_id;
    private String owner_name;
    private int block_id;
    private int room_no;
    private Date check_in_date;
    private String unit_type;
    private int area;

    public Ownedhouse(String owner_id, String owner_name, int block_id, int room_no, Date check_in_date,
                      String unit_type, int area) {
        this.owner_id = owner_id;
        this.owner_name = owner_name;
        this.block_id = block_id;
        this.room_no = room_no;
        this.check_in_date = check_in_date;
        this.unit_type = unit_type;
        this.area = area;
    }
}
