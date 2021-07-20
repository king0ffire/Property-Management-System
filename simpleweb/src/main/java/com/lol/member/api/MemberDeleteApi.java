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

@WebServlet(name = "MemberDeleteApi", urlPatterns = "/member/delete")
public class MemberDeleteApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHttp(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHttp(req, resp);
    }

    private void doHttp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String member_id = req.getParameter("member_id");

        MemberDao memberDao = new MemberDao();
        Member member = new Member();
        member.setMember_id(member_id);
        int res = memberDao.delete(member);

        String flag = "删除成功：";
        String json = JSONUtil.toJsonStr(flag + res);

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write(json);
        pw.flush();
    }
}
