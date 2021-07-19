package com.lol.owner.api;

import cn.hutool.json.JSONUtil;
import com.lol.owner.dao.Owner;
import com.lol.owner.dao.OwnerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "OwnerDeleteApi", urlPatterns = "/owner/delete")
public class OwnerDeleteApi extends HttpServlet {
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

        OwnerDao ownerDao = new OwnerDao();
        Owner owner = new Owner();
        owner.setOwner_id(owner_id);
        int res = ownerDao.delete(owner);

        String flag = "删除成功：";
        String json = JSONUtil.toJsonStr(flag + res);

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write(json);
        pw.flush();
    }
}
