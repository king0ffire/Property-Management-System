package com.lol.cost.api;

import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import com.lol.cost.dao.CostDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CostQueryApi", urlPatterns = "/cost/query")
public class CostQueryApi extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String owner_id = req.getParameter("owner_id");

        CostDao costDao = new CostDao();
        List<Entity> list = costDao.query(owner_id);

        String json = JSONUtil.toJsonStr(list);

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write(json);
        pw.flush();
    }
}
