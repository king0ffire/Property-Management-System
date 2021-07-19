package com.lol.pay.api;

import cn.hutool.json.JSONUtil;
import com.lol.pay.dao.Pay;
import com.lol.pay.dao.PayDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

@WebServlet(name = "PayAddApi", urlPatterns = "/pay/add")
public class PayAddApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHttp(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHttp(req, resp);
    }

    private void doHttp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String cost_id = req.getParameter("cost_id");
        String pay_money_str = req.getParameter("pay_money");
        String pay_time_str = req.getParameter("pay_time");
        String pay_remark = req.getParameter("pay_remark");
        double pay_money = Double.parseDouble(pay_money_str);
        Date pay_time = Date.valueOf(pay_time_str);

        PayDao payDao = new PayDao();
        Pay pay = new Pay();
        pay.setCost_id(cost_id);
        pay.setPay_money(pay_money);
        pay.setPay_time(pay_time);
        pay.setPay_remark(pay_remark);
        int res = payDao.insert(pay);

        String flag = "Inserted: PropertyDeleteApi\n" +
                "PropertyQueryApi\n" +
                "PropertyUpdateApi";
        String json = JSONUtil.toJsonStr(flag + res);

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write(json);
        pw.flush();

    }
}
