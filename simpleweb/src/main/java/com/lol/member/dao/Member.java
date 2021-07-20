package com.lol.member.dao;

import lombok.Data;

@Data
public class Member {
    private String member_id;
    private String owner_id;
    private String member_name;
    private String member_gender;
    private String member_hometown;
    private String member_phone;
}
