package com.lol.cost.api;

import cn.hutool.json.JSONUtil;
import com.lol.cost.dao.Cost;
import com.lol.cost.dao.CostDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CostDeleteApi", urlPatterns = "/com/lol/cost/delete")
public class CostDeleteApi extends HttpServlet {
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

        CostDao costDao = new CostDao();
        Cost cost = new Cost();
        cost.setCost_id(cost_id);
        int res = costDao.delete(cost);

        String flag = "删除成功：";
        String json = JSONUtil.toJsonStr(flag + res);

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write(json);
        pw.flush();
    }
}
