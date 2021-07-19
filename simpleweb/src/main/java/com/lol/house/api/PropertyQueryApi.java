package com.lol.house.api;

import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import com.lol.house.dao.DemoDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "PropertyQueryApi", urlPatterns = "/property/query")
public class PropertyQueryApi extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");

        DemoDao dao = new DemoDao();
        List<Entity> list = dao.query(name);
        String json = JSONUtil.toJsonStr(list);

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = null;
        try {
            pw = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pw.write(json);
        pw.flush();
    }
}
