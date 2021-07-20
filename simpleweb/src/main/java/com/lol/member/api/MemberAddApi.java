package com.lol.member.api;

import cn.hutool.json.JSONUtil;
import com.lol.member.dao.Member;
import com.lol.member.dao.MemberDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MemberAddApi", urlPatterns = "/member/add")
public class MemberAddApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHttp(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHttp(req, resp);
    }

    private void doHttp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String owner_id = req.getParameter("owner_id");
        String member_name = req.getParameter("member_name");
        String member_gender = req.getParameter("member_gender");
        String member_hometown = req.getParameter("member_hometown");
        String member_phone = req.getParameter("member_phone");

        MemberDao memberDao = new MemberDao();
        Member member = new Member();
        member.setOwner_id(owner_id);
        member.setMember_name(member_name);
        member.setMember_gender(member_gender);
        member.setMember_hometown(member_hometown);
        member.setMember_phone(member_phone);
        int res = memberDao.insert(member);

        String flag = "插入成功：";
        String json = JSONUtil.toJsonStr(flag + res);

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write(json);
        pw.flush();

    }
}
