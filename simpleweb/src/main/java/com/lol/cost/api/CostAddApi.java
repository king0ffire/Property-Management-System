package com.lol.cost.api;

import cn.hutool.json.JSONUtil;
import com.lol.cost.dao.CostDao;
import com.lol.cost.dao.Cost;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

@WebServlet(name = "CostAddApi", urlPatterns = "/com/lol/cost/add")
public class CostAddApi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHttp(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doHttp(req, resp);
    }

    private void doHttp(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String cost_reason = req.getParameter("cost_reason");
        String cost_time_str = req.getParameter("cost_time");
        String owner_id = req.getParameter("owner_id");
        String cost_total_str = req.getParameter("cost_total");
        Date cost_time = Date.valueOf(cost_time_str);
        double cost_total = Double.parseDouble(cost_total_str);

        CostDao costDao = new CostDao();
        Cost cost = new Cost();
        cost.setCost_reason(cost_reason);
        cost.setCost_time(cost_time);
        cost.setOwner_id(owner_id);
        cost.setCost_total(cost_total);
        int res = costDao.insert(cost);

        String flag = "插入成功：";
        String json = JSONUtil.toJsonStr(flag + res);

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write(json);
        pw.flush();

    }
}
