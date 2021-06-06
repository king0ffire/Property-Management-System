package com.max.slw.api;

import cn.hutool.json.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DemoSlt", urlPatterns = "/demo")
public class DemoSlt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doHttp(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doHttp(req, resp);
    }

    private void doHttp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println(req.getParameter("name"));

        DemoBean db = new DemoBean();
        db.setName("zhangsan");
        db.setAge(2);

        String json = JSONUtil.toJsonStr(db);

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write(json);
        pw.flush();
    }
}
