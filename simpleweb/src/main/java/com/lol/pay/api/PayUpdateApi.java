package com.lol.pay.api;

import cn.hutool.json.JSONUtil;
import com.lol.house.dao.PropertyRun;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PayUpdateApi", urlPatterns = "/pay/update")
public class PayUpdateApi extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHttp(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHttp(req, resp);
    }

    // Format is like ./house/update?pay_remark=xxx&pay_id=xxx
    // modify remark only
    private void doHttp(HttpServletRequest req, HttpServletResponse resp) {
        String pay_remark = req.getParameter("pay_remark");
        String pay_id = req.getParameter("pay_id");

        PropertyRun dao = new PropertyRun();
        int res = dao.updateProperty(pay_remark, pay_id);
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
