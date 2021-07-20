package com.lol.house.api;

import cn.hutool.json.JSONUtil;
import com.lol.house.dao.PropertyRun;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PropertyDeleteApi", urlPatterns = "/house/delete")
public class PropertyDeleteApi extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHttp(req, resp);
    }

    private void doHttp(HttpServletRequest req, HttpServletResponse resp) {
        String houseproperty_id = req.getParameter("houseproperty_id");


        PropertyRun dao = new PropertyRun();
        int res = dao.deleteProperty(houseproperty_id);
        String json = JSONUtil.toJsonStr("Deleted Successfully: " + res);


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
