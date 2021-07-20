package com.lol.build;

import lombok.Data;

import java.sql.Date;

@Data
public class Build {
    private int build_id;
    private String build_name;
    private int build_floornum;
    private int build_housenum;
    private Date build_time;
    private int build_accept;
    private String build_layout;

    public Build(int build_id, String build_name,
                 int build_floornum, int build_housenum,
                 Date build_time, int build_accept, String build_layout) {
        this.build_id = build_id;
        this.build_name = build_name;
        this.build_floornum = build_floornum;
        this.build_housenum = build_housenum;
        this.build_time = build_time;
        this.build_accept = build_accept;
        this.build_layout = build_layout;
    }
}
