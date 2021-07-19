package com.lol.member.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.db.Page;
import cn.hutool.db.PageResult;
import com.lol.owner.dao.Owner;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class MemberDao {
    public List<Entity> query(String member_name) {
        try {
            List<Entity> list = Db.use().query("select * from member where member_name LIKE ?", "%" + member_name + "%");
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public PageResult<Entity> queryPager() {
        try {
            PageResult<Entity> result = Db.use().page(Entity.create("Member"), new Page(1, 5));
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public int insert(Member member) {
        String id = UUID.randomUUID().toString();
        try {
            int res = Db.use().execute("INSERT INTO member VALUES(?,?,?,?,?,?)", id, member.getOwner_id(), member.getMember_name(), member.getMember_gender(), member.getMember_hometown(), member.getMember_phone());
            return res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public int delete(Member member) {
        try {
            int res = Db.use().execute("DELETE FROM member WHERE member_id=?", member.getMember_id());
            return res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public int update(Member member) {
        try {
            int res = Db.use().execute("UPDATE member SET member_phone=? WHERE member_id=?", member.getMember_phone(), member.getMember_id());
            return res;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
