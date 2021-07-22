package com.lol.owner.api;

import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import com.lol.owner.dao.OwnerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "OwnerQueryByID", urlPatterns = "/owner/querybyid")
public class OwnerQueryByID extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String owner_id = req.getParameter("owner_id");

        OwnerDao ownerDao = new OwnerDao();
        List<Entity> list = ownerDao.query(owner_id);

        String json = JSONUtil.toJsonStr(list);

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write(json);
        pw.flush();
    }
}
