package com.lol.pay.api;

import cn.hutool.db.Entity;
import cn.hutool.json.JSONUtil;
import com.lol.pay.dao.PayDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "PayQueryApi", urlPatterns = "/pay/query")
public class PayQueryApi extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String pay_id = req.getParameter("pay_id");

        PayDao payDao = new PayDao();
        List<Entity> list = payDao.query(pay_id);
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
