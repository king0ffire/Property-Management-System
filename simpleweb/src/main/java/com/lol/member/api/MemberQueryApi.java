package com.lol.member.api;

import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import com.lol.member.dao.MemberDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "MemberQueryApi", urlPatterns = "/member/query")
public class MemberQueryApi extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String member_name = req.getParameter("member_name");

        MemberDao memberDao = new MemberDao();
        List<Entity> list = memberDao.query(member_name);

        String json = JSONUtil.toJsonStr(list);

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write(json);
        pw.flush();

    }
}
