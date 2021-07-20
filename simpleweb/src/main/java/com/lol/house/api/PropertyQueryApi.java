package com.lol.house.api;

import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import com.lol.house.dao.PropertyRun;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "HouseQueryApi", urlPatterns = "/house/query")
public class PropertyQueryApi extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String house_id = req.getParameter("house_id");

        PropertyRun dao = new PropertyRun();
        List<Entity> list = dao.query(house_id);
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
