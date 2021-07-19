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

@WebServlet(name = "HouseUpdateApi", urlPatterns = "/house/update")
public class PropertyUpdateApi extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHttp(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHttp(req, resp);
    }

    // Format is like ./person/update?name=xxx&to=XXX
    private void doHttp(HttpServletRequest req, HttpServletResponse resp) {
        String updated_landlord_id = req.getParameter("new");
        String house_id = req.getParameter("house_id");

        PropertyRun dao = new PropertyRun();
        int res = dao.updateProperty(updated_landlord_id, house_id);
        String json = JSONUtil.toJsonStr("Updated: " + res);


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
