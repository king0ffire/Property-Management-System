package com.lol.statistics.owner.api;

import cn.hutool.json.JSONUtil;
import com.lol.statistics.owner.Property;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "totalpropertyapi", urlPatterns = "/statistics/totalproperty")
public class totalpropertyapi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doHttp(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doHttp(req, resp);
    }

    private void doHttp(HttpServletRequest req, HttpServletResponse resp) throws IOException {//查询某个人拥有的房产数
        String id = req.getParameter("owner_id");
        Boolean bl = false;
        String json = null;


        if (id == null) {
            json = JSONUtil.toJsonStr("nothing???");
            System.out.println("nothing???");
        } else {
            json = JSONUtil.toJsonStr("something wrong with your input");
        }
        Property tot = new Property();
        Map<String, Object> map = tot.total(id);
        json=JSONUtil.toJsonStr(map);

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write(json);
        pw.flush();
    }
}
